[![Dokka docs](https://img.shields.io/badge/docs-dokka-orange?style=flat-square)](http://mpetuska.github.io/template-kmp-library)
[![Version maven-central](https://img.shields.io/maven-central/v/dev.petuska/template-kmp-library?logo=apache-maven&style=flat-square)](https://mvnrepository.com/artifact/dev.petuska/template-kmp-library/latest)

# template-kmp-library

Kotlin multiplatform library template.

Has a baseline setup for a multiplatform library supporting all
kotlin [targets](https://kotlinlang.org/docs/mpp-supported-platforms.html)
except deprecated wasm32.

## Features

* Native target grouping and shared sourceSets
* Wrapper library module that declares dependencies on all lib modules
* Uniform configuration via conventional plugins `convention.common`, `convention.library` & `convention.publishing`
* Local `test` module for shared test utilities (a helper function to run coroutine tests in common sourceSet included)
* Local `sandbox` module for easy library consumer side checks
* Publication control to avoid multiple publications for targets that can be built on multiple hosts
* `ktlint` plugin with automatic `git-hooks`
* `refreshVersions` plugin for better library version control
* Main host for publications can be changed via `gradle.properties#project.mainOS` property
* Gradle Build Scan setup
* GH dependabot setup
* GH release action for platform dependant publications
* GH check action for platform dependant tests on PRs
* Maven Central publishing setup
* GH Packages publishing setup

## Setup

Here are some pointers to help you get up and running with this template

### Badges

This README contains some useful badges for your project. To tailor them to your artefacts the following changes needs
to be made:

* `Dokka docs` - change the link as `(http://$GH_USERNAME.github.io/$GH_PROJECT_NAME)`
* `Version maven-central - change all occurrences of `dev.petuska` to your own group and `template-kmp-library` to your
  root library name

### gradle.properties

Have a look at `gradle.properties` file and change these properties as needed

* `gh.owner.id` - main library developer's username
* `gh.owner.name` - main library developer's name
* `gh.owner.email` - main library developer's email
* `project.mainOS` - main host to publish cross-platform artefacts from (to avoid duplicate publications)
* `group` - artefacts' group
* `description` - library description
* `version` - library version (overridden in CI, so doesn't really matter here)

### Modules

All the library modules should go to `/lib/` directory and be included in `/settings.gradle.kts`. There are already two
sample modules to illustrate how simple the setup is (`/lib/template-kmp-library-core` & `template-kmp-library-dsl`).
They both contain some sample code and tests that make use of local `/test` module with testing utilities.

### Kotlin Targets

The template comes packed with all kotlin targets preconfigured, however if you want to remove some of them or tweak the
config, you only need to make changes as needed in `/buildSrc/src/main/kotlin/convention.library.gradle.kts`. Removing
targets from this file will not break any publications as they're configured on top of pre-registered targets.

### GitHub Actions

The template also comes with GH actions to check builds on PRs and publish artefacts when creating a GH release. By
default, it'll publish to GH packages and Maven Central. However to fully unlock Maven Central publishing, you'll need
to add these secrets to your GH repository. If you want to quickly disable Maven Central publishing, you can toggle it
at `.github/workflows/release.yml#L80`

* `SIGNING_KEY` - GPG signing key
* `SIGNING_KEY_ID` - GPG signing key ID
* `SIGNING_PASSWORD` - GPG signing key password (if set)
* `SONATYPE_PASSWORD` - Sonatype PAT username
* `SONATYPE_USERNAME` - Sonatype PAT password
