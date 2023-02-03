# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [SNAPSHOT]

### Verified Versions

- [JDK]\: 11+
- [Kotlin]\: 1.8.0
- [Compose]\: 1.3.0
- [MDC]\: ^14.0.0

### Added

### Changed

### Removed

---

## [0.1.0]

### Verified Versions

- [JDK]\: 11+
- [Kotlin]\: 1.8.0
- [Compose]\: 1.3.0
- [MDC]\: ^14.0.0

### Added

### Changed

- Bumped kotlin/compose versions
- Fixed adding/removing items dynamically in MDCSelect
- Replaced old DOM-based external MDC component management with CompositionLocal and
  DisposableEffect based solutions

### Removed

- All old DOM-based MDC component management and effects

---

## [0.0.5]

### Verified Versions

- [JDK]\: 11+
- [Kotlin]\: 1.7.10
- [Compose]\: 1.2.0-alpha01-dev745
- [MDC]\: ^14.0.0

### Added

### Changed

- Kotlin and Compose version bumps

### Removed

---

## [0.0.4]

### Verified Versions

- [JDK]\: 11+
- [Kotlin]\: 1.6.21
- [Compose]\: 1.2.0-alpha01-dev679
- [MDC]\: ^14.0.0

### Added

- [x] mdc-chips
- [x] mdc-banner
- [x] mdc-fab
- [x] mdc-image-list
- [x] mdc-touch-target
- [x] mdc-elevation
- [x] mdc-line-ripple
- [x] mdc-floating-label
- [x] mdc-notched-outline
- Proper `@DslMarker` usage to prevent leaking scopes

### Changed

- Standardised event handlers
- Reworked `MDCSelect` to be more lightweight and customisable
- Introduced new `CompositionLocal` based MDC component management making it accessible from
  anywhere down the component
  hierarchy
- Reworked sandbox with new `katalog` tooling for more streamlined experience and reduced
  boilerplate
- Rewritten all existing samples to be fully interactive
- Optimised MDC component state management for most of the components
- `opts` based property builder was replaced with top-level properties

### Removed

- `initialiseMDC` and `MDCInitEffect` which were relying on storing the MDC component on the native
  HTML element

---

## [0.0.3]

### Verified Versions

- [JDK]\: 11
- [Kotlin]\: 1.6.21
- [Compose]\: 1.2.0-alpha01-dev675
- [MDC]\: ^13.0.0

### Added

- [x] mdc-switch
- [x] mdc-slider
- [x] mdc-select
- [x] mdc-dialog
- [x] mdc-circular-progress
- [x] mdc-data-table
- [x] mdc-tab-indicator
- [x] mdc-tab-bar
- [x] mdc-tab-indicator
- [x] mdc-tab-scroller
- [x] mdc-tab

### Changed

### Removed

---

## [0.0.2] - 2021-12-28

### Verified Versions

- [JDK]\: 11
- [Kotlin]\: 1.6.10
- [Compose]\: 1.0.1
- [MDC]\: ^13.0.0

### Added

- [x] mdc-radio
- [x] mdc-tooltip
- [x] mdc-segmented-button
- [x] mdc-snackbar
- [x] material-icons
- New `dev.petuska:kmdcx` shortcut artefact for KMDC extension and companion modules
- Contributing guidelines and code of conduct

### Changed

- Upgraded Kotlin and Compose versions
- Fixed teardown hooks on some components
- Revisited old components to make all of them controlled for consistency
- Reworked sandbox
- [MDC]Typography extended to support custom attributes

### Removed

---

## [0.0.1] - 2021-11-21

### Verified Versions

- [JDK]\: 11
- [Kotlin]\: 1.5.31
- [Compose]\: 1.0.0-rc1
- [MDC]\: ^13.0.0

### Added

- [x] mdc-button
- [x] mdc-card
- [x] mdc-checkbox
- [x] mdc-drawer
- [x] mdc-form-field
- [x] mdc-icon-button
- [x] mdc-layout-grid
- [x] mdc-linear-progress
- [x] mdc-list
- [x] mdc-ripple
- [x] mdc-textfield
- [x] mdc-top-app-bar
- [x] mdc-typography

### Changed

- Upgraded Kotlin and Compose versions
- Fixed teardown hooks on some components
- Revisited old components to make all of them controlled for consistency
- Reworked sandbox
- [MDC]Typography extended to support custom attributes

### Removed

---

[SNAPSHOT]: https://github.com/mpetuska/npm-publish/compare/0.1.0...HEAD

[0.1.0]: https://github.com/mpetuska/npm-publish/compare/0.0.5...0.1.0

[0.0.5]: https://github.com/mpetuska/npm-publish/compare/0.0.4...0.0.5

[0.0.4]: https://github.com/mpetuska/npm-publish/compare/0.0.3...0.0.4

[0.0.3]: https://github.com/mpetuska/npm-publish/compare/0.0.2...0.0.3

[0.0.2]: https://github.com/mpetuska/npm-publish/compare/0.0.1...0.0.2

[0.0.1]: https://github.com/mpetuska/npm-publish/releases/tag/0.0.1

[JDK]: https://adoptium.net/temurin/releases/

[Compose]: https://github.com/JetBrains/compose-jb/releases

[Kotlin]: https://github.com/JetBrains/Kotlin/releases

[MDC]: https://github.com/material-components/material-components-web/releases
