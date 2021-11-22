[![Dokka docs](https://img.shields.io/badge/docs-dokka-orange?style=flat-square)](http://mpetuska.github.io/kmdc)
[![Version maven-central](https://img.shields.io/maven-central/v/dev.petuska/kmdc?logo=apache-maven&style=flat-square)](https://mvnrepository.com/artifact/dev.petuska/kmdc/latest)

# Kompose Material Design Components (KMDC)

A set of kotlin wrappers
over [material-components-web@13.0.0](https://github.com/material-components/material-components-web/tree/v13.0.0)
library providing Jetbrains Compose DSL for building beautiful WEB UIs. The API surface is identical to JS version,
except for few places where slight adjustments are made to make it more fluid for compose.

## Progress

Here's a tracker list of currently completed *material-components-web* modules (13/43):
- [ ] mdc-animation
- [ ] mdc-auto-init
- [ ] mdc-banner
- [ ] mdc-base
- [x] mdc-button
- [x] mdc-card
- [x] mdc-checkbox
- [ ] mdc-chips
- [ ] mdc-circular-progress
- [ ] mdc-data-table
- [ ] mdc-density
- [ ] mdc-dialog
- [ ] mdc-dom
- [x] mdc-drawer
- [ ] mdc-elevation
- [ ] mdc-fab
- [ ] mdc-feature-targeting
- [ ] mdc-floating-label
- [x] mdc-form-field
- [x] mdc-icon-button
- [ ] mdc-image-list
- [x] mdc-layout-grid
- [ ] mdc-line-ripple
- [x] mdc-linear-progress
- [x] mdc-list
- [ ] mdc-menu-surface
- [ ] mdc-menu
- [ ] mdc-notched-outline
- [ ] mdc-progress-indicator
- [ ] mdc-radio
- [x] mdc-ripple
- [ ] mdc-rtl
- [ ] mdc-segmented-button
- [ ] mdc-select
- [ ] mdc-shape
- [ ] mdc-slider
- [ ] mdc-snackbar
- [ ] mdc-switch
- [ ] mdc-tab-bar
- [ ] mdc-tab-indicator
- [ ] mdc-tab-scroller
- [ ] mdc-tab
- [x] mdc-textfield
- [ ] mdc-tooltip
- [x] mdc-top-app-bar
- [ ] mdc-touch-target
- [x] mdc-typography

# Developer Setup
* Install JDK 11+
* Run `./gradlew assemble` to build js binaries
* Use `./sandbox/` to render components in browser (needs to be linked separately in IDEA)
  * `./gradlew jsBrowserRun -t` to start development server
  * Visit [http://localhost:3000](http://localhost:3000) to see your content
