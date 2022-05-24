# Tips and Tricks

## Prerequisites

Bellow are the key concepts required to work with KMDC efficiently:

* Familiarity with [compose-web].
* Familiarity with [Kotlin/JS interop][kjs-interop]
* Familiarity with [MDC architecture][mdc-architecture]
* Familiarity with [Integrating MDC Web into Frameworks][mdc-framework-integration]

## How to create a KMDC wrapper

> _MDC component_ refers to the [material-components-web] framework component.
> A _KMDC component_ is a Kotlin wrapper for an MDC component.

Before starting, here are some general pointers about MDC & KMDC architecture:

* Each MDC component lives in a separate KMDC [module](../kmdc).
* Some MDC components depend on SCSS, which needs to be imported for it to function properly.
* Inlining CSS imports does not prevent end-users from using SCSS if they so choose.
* Most MDC components have a companion JS object, which needs to be initialised and disposed together with wrapping
  a composable.
* Each KMDC component has (in the following order)
    1. a set of custom dedicated primitive arguments (e.g. `checked` argument for [MDCCheckbox.kt])
    2. the usual [compose-web] attribute builders (`attrs` & `content`).
* KMDC component options should aim to be as expressive in their naming and typing as possible to be easily discoverable
  in the public API

### Basics

#### Auto-importing an SCSS module

Most MDC components depend on some SCSS to function properly.
To make the end-user experience smoother, KMDC auto-imports
such SCSS where needed and hides this fact from the consumers.

First, you need to create a reference to appropriate SCSS module.

```kotlin
@JsModule("@material/checkbox/mdc-checkbox.scss") // 1
external val Style: dynamic // 2
```

1. Tells the Kotlin compiler that the following declaration refers to a JS module and should use the JS native module
   resolver.
   This is further picked up by webpack SCSS loader to eventually inline the SCSS module into the final JS executable.
2. Declares the Kotlin reference to it as `external` value with `dynamic` type, since we only need to know the reference
   and not the type.

Once you have a reference to it, you need to make sure that DCE does not remove it. This is done by holding a static
reference in a top-level composable.

```kotlin
@Composable
fun MDCCheckbox() {
  Style
  // Rest of the component logic
}
```

#### Initialising and Disposing an MDC JS object

Most of the MDC components also depend on MDC JS objects that need to be initialised and disposed together with the
underlying HTML component's lifecycle. In such cases, Kotlin needs to know about its MDC JS interface and types to be
able to use them from compose context.

Firstly, declare the external JS module file named `_module.kt`

```kotlin
@file:JsModule("@material/list")

// 1

external class MDCList(element: Element) : MDCBaseModule.MDCComponent<dynamic> { // 2
  var vertical: Boolean // 3
  val typeaheadInProgress: Boolean // 4
  fun layout() // 5
}
```

1. Tells Kotlin compiler that the following declaration refers to a JS module and should use the JS native module
   resolver. All declarations inside will be mapped 1:1 to
   the JS module's `module.exports` or cumulative list of es6 `export` statements. The declarations are read from the
   entry file declared in npm package's `package.json#main`field, since we do not specify further path from base module
   name (`@material/checkbox`).
2. Declares an `external class` with a constructor from the external module, that extends another external class.
3. Declares a mutable `property` property of this class.
4. Declares an immutable `property` property of this class.
5. Declares a `method` of this class.

When you have the external declarations ready, you can start using them to implement an adapter lifecycle into your
composables. This is done via the `MDCProvider` helper function inside the underlying HTML element's `content` builder.

```kotlin
@Composable
fun MDCCheckbox(vertical: Boolean) {
  Div(attrs = {
    classes("mdc-list")
  }) {
    MDCProvider(::MDCList) {
      MDCStateEffect(vertical, MDCList::vertical)
      // Composable content
    }
  }
}
```

The MDC component state can be accessed and synchronised anywhere from within the `MDCProvider` scope using these custom
kmdc utilities:

* `MDCSideEffect` -> baseline effect allowing you to run arbitrary code on `MDC` component when keys change
* `MDCStateEffect` -> more specialised version of `MDCSideEffect` that automatically syncs up given value with the
  specific `MDC` component property or method
* `localMDC` -> allows one to retrieve the `MDC` component reference directly

### Flow

1. Pick an MDC component to wrap and familiarize yourself with its interface.
    * Read the MDC component's README (e.g.: [mdc-checkbox]) to understand how its HTML works.
    * Check out the MDC component's Typescript/JavaScript interface to understand how its underlying JS control works.
2. Create the KMDC component. See [MDCCheckbox.kt] for an example.
    1. Create new `kmdc-` module in [../kmdc]
    2. Create a wrapper for top-level MDC component
        1. If needed, declare the MDC component's SCSS module and reference it in KMDC's main composable function.
        2. If needed, declare a JS external module for the MDC component object and use it to initialise and synchronise
           with compose state
        3. If needed, create wrappers for your chosen module's MDC subcomponents.
    3. Create a new `Showcases` file in [../sandbox/src/jsMain/kotlin/showcases] to render and test your composable in
       action!

[compose-web]: https://github.com/JetBrains/compose-jb/tree/master/tutorials/Web

[kjs-interop]: https://kotlinlang.org/docs/js-interop.html

[material-components-web]: https://github.com/material-components/material-components-web/tree/v14.0.0

[mdc-architecture]: https://github.com/material-components/material-components-web/blob/v14.0.0/docs/code/architecture.md

[mdc-framework-integration]: https://github.com/material-components/material-components-web/blob/v14.0.0/docs/integrating-into-frameworks.md#the-simple-approach-wrapping-mdc-web-vanilla-components

[mdc-checkbox]: https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-checkbox

[MDCCheckbox.kt]: ../kmdc/kmdc-checkbox/src/jsMain/kotlin/MDCCheckbox.kt
