# Tips and Tricks

## Prerequisites

Bellow are the key concepts required to work with KMDC efficiently:

* Familiarity with [compose-web].
* Familiarity with [Kotlin/JS interop][kjs-interop]
* Familiarity with [MDC architecture][mdc-architecture]
* Familiarity with [Integrating MDC Web into Frameworks][mdc-framework-integration]

## How to create a KMDC wrapper

Before starting, here are some general pointers about MDC & KMDC architecture:

* Each MDC component lives in a separate KMDC [module](../lib).
* Some MDC components depend on CSS, which needs to be imported for it to function properly
* Inlining CSS imports does not prevent end-users from using SCSS if they so choose
* Most MDC components have companion JS adaptor, which needs to be initialised and disposed together with wrapping
  composable
* Each Kmdc component has (in the following order)
    1. Only if absolutely required, custom dedicated primitive argument (e.g. `checked` argument for [MDCCheckbox.kt])
    2. KMDC component options builder (`opts`),
    3. The usual [compose-web] attribute builders (`attrs` & `content`)
* KMDC component options feature the same builder-style design as attributes.

> _MDC component_ refers to the [material.io Web](https://material.io/develop/web) framework component.
> A _KMDC component_ is a Kotlin wrapper for an MDC component.

### Basics

#### Auto-importing CSS module

Most of MDC components depend on some CSS to function properly. To make end-user experience smoother, KMDC auto-imports
such CSS where needed and hides this fact from the consumers.

First, you need to create a reference to appropriate CSS module.

```kotlin
@JsModule("@material/checkbox/dist/mdc.checkbox.css") // 1
public external val MDCCheckboxStyle: dynamic // 2
```

1. Tells kotlin compiler that the following declaration refers to JS module and should use JS native module resolver.
   This is further picked up by webpack CSS loader to eventually inline the CSS module into the final JS executable.
2. Declares the kotlin reference to it as `external` value with `dynamic` type, since we only need to know the reference
   and not the type

Once you have a reference to it, you need to make sure that DCE does not remove it. This is done by holding a static
reference in a top-level composable.

```kotlin
@Composable
public fun MDCCheckbox() {
  MDCCheckboxStyle
  // Rest of the composition logic
}
```

#### Initialising and Disposing JS Adapter

Most of the MDC components also depend on JS adaptors that needs to be initialised and disposed together with the
underlying HTML component's lifecycle. In such cases, kotlin needs to know about MDC JS interface and types to be able
to use them from compose context.

Firstly, declare external JS module

```kotlin
@JsModule("@material/checkbox") // 1
public external object MDCCheckboxModule { // 2
  public class MDCCheckbox(element: Element) : MDCFormFieldModule.MDCFormFieldInput { // 3
    public companion object {
      public fun attachTo(element: Element): MDCCheckbox // 4
    }
    
    public fun destroy() // 5
    public var checked: Boolean // 6
    override val ripple: MDCRippleModule.MDCRipple? // 7
  }
}
```

1. Tells kotlin compiler that the following declaration refers to JS module and should use JS native module resolver.
2. Declares a container for the entire JS module as an `external` object. All declarations inside will be mapped 1:1 to
   the JS module's `module.exports` or cumulative list of es6 `export` statements. The declarations are read from the
   entry file declared in npm package's `package.json#main`field, since we do not specify further path from base module
   name (`@material/checkbox`) in #1
3. Declares a `class` with a constructor from the external module, that extends another external class
4. Declares a `static method` that can be used without an instance of this class
5. Declares a `method` of this class
6. Declares a mutable `property` property of this class
7. Declares a `method override` that this class has, which comes from super class

When you have the external declarations ready, you can start using them to implement adapter lifecycle into your
composables. This is done via `ref` and `ref::onDispose` helper function inside `attrs` builder, which gives you direct
access to an underlying HTML component.

```kotlin
@Composable
public fun MDCCheckbox() {
  Div(attrs = {
    ref { // 1
      val mdc = MDCCheckboxModule.MDCCheckbox.attachTo(it) // 2
      it.mdc = mdc // 3
      onDispose { // 4
        it.mdc<MDCCheckboxModule.MDCCheckbox> { destroy() } // 5
      }
    }
  }) {
    // Composable content
  }
}
```

1. Invokes `ref` block, which gives us access to underlying HTML element as an `it` implicit argument
2. Uses the reference to the HTML element to initialise appropriate MDC adapter using static `attachTo` method. This can
   also be done by invoking the constructor. Both ways return a reference to the initialised adaptor which you need to
   store.
3. Uses KMDC utility extensions to store the adaptor reference as a new `mdc` property under HTML element.
4. Registers a disposal hook, which will be invoked when the composable leaves the composition.
5. Uses yet another KMDC utility extension, to execute `MDCCheckbox::destroy` if the HTMLElement has an appropriate mdc
   adaptor attached to it.

### Flow

1. Pick an MDC component to wrap and familiarize yourself with its interface.
    * Read the MDC component's README (e.g.: [mdc-checkbox]) to understand how its HTML works.
    * Check out the MDC component's Typescript/JavaScript interface to understand how its underlying JS control works.
2. Create the KMDC component. See [MDCCheckbox.kt] for an example.
    1. Create new `kmdc-` module in [../lib]
    2. Create a wrapper for top-level MDC component
        1. If needed, declare MDC component's CSS module and reference it in main composable's content
        2. If needed, declare JS external module for MDC component adapter and use it to initialise and dispose
           composable HTML ref
        3. If needed, create wrappers for MDC subcomponents your chosen module has
    3. Create a new `Samples` file in [../sandbox/src/jsMain/kotlin/samples] to render and test your composable in
       action!

[compose-web]: https://github.com/JetBrains/compose-jb/tree/master/tutorials/Web

[kjs-interop]: https://kotlinlang.org/docs/js-interop.html

[mdc-architecture]: https://github.com/material-components/material-components-web/blob/v13.0.0/docs/code/architecture.md

[mdc-framework-integration]: https://github.com/material-components/material-components-web/blob/v13.0.0/docs/integrating-into-frameworks.md#the-simple-approach-wrapping-mdc-web-vanilla-components

[mdc-checkbox]: https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-checkbox

[MDCCheckbox.kt]: ../lib/kmdc-checkbox/src/jsMain/kotlin/MDCCheckbox.kt
