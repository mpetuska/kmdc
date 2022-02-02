[![Slack chat](https://img.shields.io/badge/kotlinlang-%23kmdc-green?logo=slack&style=flat-square)](https://kotlinlang.slack.com/archives/CNR7ARJGJ)
[![Dokka docs](https://img.shields.io/badge/docs-dokka-orange?style=flat-square)](http://mpetuska.github.io/kmdc)
[![Version maven-central](https://img.shields.io/maven-central/v/dev.petuska/kmdc?logo=apache-maven&style=flat-square)](https://mvnrepository.com/artifact/dev.petuska/kmdc/latest)

# Kompose Material Design Components (KMDC)

A set of kotlin wrappers
over [material-components-web@13.0.0][material-components-web]
library providing Jetbrains Compose DSL for building beautiful WEB UIs. The API surface is identical to JS version,
except for few places where slight adjustments are made to make it more fluid for compose.

## Setup

KMDC wraps each MDC module 1:1 and as such allows you to pick and choose which exact components you'd like to use. This
is recommended approach as it helps in reducing bundle size. However, for the lazy ones out there, a "shortcut" module
is also available, which brings in all KMDC modules as transitive dependencies under a single dependency.

Either approach can be installed by declaring relevant dependencies in your `jsMain` sourceSet.

```kotlin
plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
}
kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        // Be lazy and use the shortcut
        implementation("dev.petuska:kmdc:_")
        implementation("dev.petuska:kmdcx:_")
        
        // Do some work and see dem gains
        implementation("dev.petuska:kmdc-button:_")
        implementation("dev.petuska:kmdc-radio:_")
        implementation("dev.petuska:kmdcx-icons:_")
      }
    }
  }
}
```

### Usage

Most of the API maps closely to MDC JS API, making all examples there semi-valid. KMDC components follow a specific
naming convention to make its components more discoverable as well. The convention
is `MDC[UpperCamelCaseMDCComponentName]` (e.g. `MDCTopAppBar`). Most of the components also follow the same argument
order schema:

1. `opts: (MDCComponentOpts.() -> Unit)? = null` - MDC-specific options overrides
2. `attrs: (ArrtsBuilder<out HTMLElement>.() -> Unit)? = null` - compose attributes builder for the underlying HTML
   element
3. `content: (ElementBuilder<out HTMLElement>.() -> Unit)? = null` - compose inner content builder for the underlying
   HTML element

Here's a quick peek how these things come together (more samples can be found in
the [sandbox](./sandbox/src/jsMain/kotlin/samples))

```kotlin
@Composable
fun Sample() {
  var checked by remember { mutableStateOf(false) } // Declaring controlled state
  
  MDCFormField { // Using implicit `content` argument to wrap MDCCheckbox inside MDCFormField component as recommended by MDC docs
    MDCCheckbox(
      checked = checked, // MDCCheckbox breaks regular args schema in favour of more convenient usage
      opts = { label = it }, // Overriding MDCCheckbox-specific options
      attrs = { onClick { checked = !checked } } // Overriding underlying HTMLInput element attributes
    ) // MDCCheckbox doesn't allow for additional inner content
  }
}
```

### Progress

Here's a tracker list of currently completed [material-components-web] modules (26/49):

- [ ] mdc-animation (SASS)
- [x] mdc-auto-init (won't wrap)
- [ ] mdc-banner
- [x] mdc-base (won't wrap)
- [x] mdc-button
- [x] mdc-card
- [x] mdc-checkbox
- [ ] mdc-chips
- [ ] mdc-circular-progress
- [ ] mdc-data-table
- [x] mdc-density (won't wrap)
- [x] mdc-dialog
- [x] mdc-dom (won't wrap)
- [x] mdc-drawer
- [ ] mdc-elevation
- [ ] mdc-fab
- [x] mdc-feature-targeting (won't wrap)
- [ ] mdc-floating-label
- [x] mdc-form-field
- [x] mdc-icon-button
- [ ] mdc-image-list
- [x] mdc-layout-grid
- [ ] mdc-line-ripple
- [x] mdc-linear-progress
- [x] mdc-list
- [x] mdc-menu-surface
- [x] mdc-menu
- [ ] mdc-notched-outline
- [x] mdc-progress-indicator (won't wrap)
- [x] mdc-radio
- [x] mdc-ripple
- [ ] mdc-rtl (SASS)
- [x] mdc-segmented-button
- [ ] mdc-select
- [ ] mdc-shape (SASS)
- [x] mdc-slider
- [x] mdc-snackbar
- [x] mdc-switch
- [ ] mdc-tab-bar
- [ ] mdc-tab-indicator
- [ ] mdc-tab-scroller
- [ ] mdc-tab
- [x] mdc-textfield
- [ ] mdc-theme (SASS)
- [x] mdc-tokens (won't wrap)
- [x] mdc-tooltip
- [x] mdc-top-app-bar
- [ ] mdc-touch-target
- [x] mdc-typography

Other libraries and extensions:

- [x] material-icons

## Contributing

All contributions are welcome. Have a look for
a [good first issue](https://github.com/mpetuska/kmdc/issues?q=is%3Aopen+is%3Aissue+label%3A%22good+first+issue%22)
in the issue tracker, or open your own issue if you have some ideas. If you want to chat, either start
a [discussion](https://github.com/mpetuska/kmdc/discussions) or ping me
on [slack](https://kotlinlang.slack.com/team/UL1A5BA2X).
> Further details can be found in [Contributing Guidelines](./docs/CONTRIBUTING.md)

### Module Structure

KMDC project modules can be categorised into three groups:

* Core MDC wrappers - grouped under [./kmdc](./kmdc) meta-module
* Extensions of core wrappers or relevant non-kmdc wrappers - grouped under [./kmdcx](./kmdcx) meta-module
* Local testing utilities - grouped under [./test](./test) meta-module

### Developer Setup

* Install JDK 11+
* Run `./gradlew assemble` to build js binaries
* Use `./sandbox/` to render components in browser (needs to be linked separately in IDEA)
    * `./gradlew jsBrowserRun -t` to start development server
    * Visit [http://localhost:3000](http://localhost:3000) to see your content
    * If you're adding a new component, render it by creating [Samples](./sandbox/src/jsMain/kotlin/samples/Button.kt)
      property for it
    * Thanks to gradle continuous mode, any change in kmdc modules will trigger automatic refresh of sandbox and the
      browser. It takes a few seconds after you save your changes, so be patient.

> Further details can be found in [Contributing Guidelines](./docs/CONTRIBUTING.md#what-should-i-know-before-i-get-started)

[material-components-web]: https://github.com/material-components/material-components-web/tree/v13.0.0
