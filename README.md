[![Slack chat](https://img.shields.io/badge/kotlinlang-%23kmdc-green?logo=slack&style=flat-square)](https://kotlinlang.slack.com/archives/CNR7ARJGJ)
[![Dokka docs](https://img.shields.io/badge/docs-dokka-orange?style=flat-square)](http://mpetuska.github.io/kmdc)
[![Version maven-central](https://img.shields.io/maven-central/v/dev.petuska/kmdc?logo=apache-maven&style=flat-square)](https://mvnrepository.com/artifact/dev.petuska/kmdc/latest)
[![Version maven-snapshot](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fs01.oss.sonatype.org%2Fcontent%2Frepositories%2Fsnapshots%2Fdev%2Fpetuska%2Fkmdc%2Fmaven-metadata.xml&logo=apache-maven&label=maven-snapshot&style=flat-square)](https://s01.oss.sonatype.org/content/repositories/snapshots/dev/petuska/kmdc/)

# Kompose Material Design Components (KMDC)

> The library is currently very experimental with no API stability guarantees. Breaking changes are being introduced
> each release.

A set of Kotlin wrappers
over [material-components-web@14.0.0][material-components-web]
library providing Jetbrains Compose DSL for building beautiful WEB UIs. The API surface is identical to JS version,
except for few places where slight adjustments are made to make it more fluid for compose.

## Setup

KMDC wraps each MDC module 1:1 and as such allows you to pick and choose which exact components you'd like to use. This
is recommended approach as it helps in reducing bundle size. However, for the lazy ones out there, a "shortcut" module
is also available, which brings in all KMDC modules as transitive dependencies under a single dependency.

Either approach can be installed by declaring relevant dependencies in your `jsMain` sourceSet.

Additionally, you need to enable SCSS support.

```kotlin
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}
kotlin {
    js {
        browser {
            commonWebpackConfig {
                cssSupport { enabled.set(true) }
                scssSupport { enabled.set(true) }
            }
        }
    }
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
is `MDC[UpperCamelCaseMDCComponentName]` (e.g. `MDCTopAppBar`) for the top-level component
and `UpperCamelCaseLogicalName` for all subcomponents. Most of the components also follow the same argument order
schema:

1. `...requiredMdcOptions` - MDC-specific options with no default values
2. `...optionalMdcOptions` - MDC-specific options with default values
3.`attrs: (AttrsBuilder<out HTMLElement>.() -> Unit)? = null` - compose attributes builder for the underlying HTML element
4.`content: (ComposableBuilder<out HTMLElement>.() -> Unit)? = null` - compose inner content builder for the underlying HTML element

Here's a quick peek how these things come together (more showcases can be found in
the [sandbox](./sandbox/src/jsMain/showcases))

```kotlin
@Composable
fun Showcase() {
    var checked by remember { mutableStateOf(false) } // Declaring controlled state

    MDCFormField { // Using implicit `content` argument to wrap MDCCheckbox inside MDCFormField UI as recommended by the MDC docs
        MDCCheckbox(
            checked = checked,
            label = "Yes/No",
            attrs = { // Overriding underlying HTMLInput element attributes
                onInput { checked = !checked }
            }
        ) // MDCCheckbox doesn't allow for additional inner content
    }
}
```

### Progress

Here's a tracker list of currently completed [material-components-web] modules:

- [ ] kmdc-animation (SASS)
- [ ] kmdc-auto-init (won't wrap)
- [x] kmdc-banner
- [ ] kmdc-base (won't wrap)
- [x] kmdc-button
- [x] kmdc-card
- [x] kmdc-checkbox
- [x] kmdc-chips
- [x] kmdc-circular-progress
- [x] kmdc-data-table
- [ ] kmdc-density (won't wrap)
- [x] kmdc-dialog
- [ ] kmdc-dom (won't wrap)
- [x] kmdc-drawer
- [x] kmdc-elevation
- [x] kmdc-fab
- [ ] kmdc-feature-targeting (won't wrap)
- [x] kmdc-floating-label
- [x] kmdc-form-field
- [x] kmdc-icon-button
- [x] kmdc-image-list
- [x] kmdc-layout-grid
- [x] kmdc-line-ripple
- [x] kmdc-linear-progress
- [x] kmdc-list
- [x] kmdc-menu-surface
- [x] kmdc-menu
- [x] kmdc-notched-outline
- [ ] kmdc-progress-indicator (won't wrap)
- [x] kmdc-radio
- [x] kmdc-ripple
- [ ] kmdc-rtl (SASS)
- [x] kmdc-segmented-button
- [x] kmdc-select
- [ ] kmdc-shape (SASS)
- [x] kmdc-slider
- [x] kmdc-snackbar
- [x] kmdc-switch
- [x] kmdc-tab-bar
- [x] kmdc-tab-indicator
- [x] kmdc-tab-scroller
- [x] kmdc-tab
- [x] kmdc-textfield
- [ ] kmdc-theme (SASS)
- [ ] kmdc-tokens (won't wrap)
- [x] kmdc-tooltip
- [x] kmdc-top-app-bar
- [x] kmdc-touch-target
- [x] kmdc-typography

Other libraries and extensions:

- [x] kmdc-icons

### Module Structure

KMDC project modules can be categorised into three groups:

* Core MDC wrappers - grouped under [./kmdc](./kmdc) meta-module
* Extensions of core wrappers or relevant non-kmdc wrappers - grouped under [./kmdcx](./kmdcx) meta-module

### Developer Setup

* Install JDK 11+
* Run `./gradlew assemble` to build js binaries
* Use `./sandbox/` to render components in browser (needs to be linked separately in IDEA)
    * `./gradlew jsBrowserRun -t` to start development server
    * Visit [http://localhost:3000](http://localhost:3000) to see your content
    * If you're adding a new component, render it by creating [Showcases](./sandbox/src/jsMain/showcases/MDCButton.kt)
      file for it
    * Thanks to gradle continuous mode, any change in kmdc modules will trigger automatic refresh of sandbox and the
      browser. It takes a few seconds after you save your changes, so be patient.

> Further details can be found
> in [Contributing Guidelines](./docs/CONTRIBUTING.md#what-should-i-know-before-i-get-started)

## Contributing

All contributions are welcome. Have a look for
a [good first issue](https://github.com/mpetuska/kmdc/issues?q=is%3Aopen+is%3Aissue+label%3A%22good+first+issue%22)
in the issue tracker, or open your own issue if you have some ideas. If you want to chat, either start
a [discussion](https://github.com/mpetuska/kmdc/discussions) or ping me
on [slack](https://kotlinlang.slack.com/team/UL1A5BA2X).
> Further details can be found in [Contributing Guidelines](./docs/CONTRIBUTING.md)

Thanks to all the people who contributed to kmdc so far!

<a href="https://github.com/mpetuska/kmdc/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=mpetuska/kmdc" />
</a>

[material-components-web]: https://github.com/material-components/material-components-web/tree/v14.0.0
