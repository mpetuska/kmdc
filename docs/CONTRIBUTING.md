# Contributing to KMDC

:+1::tada: First off, thanks for taking the time to contribute! :tada::+1:

The following is a set of guidelines for contributing to KMDC and its packages. These are mostly guidelines, not rules.
Use your best judgment, and feel free to propose changes to this document in a pull request.

## Table Of Contents

* [Code of Conduct](#code-of-conduct)
* [I don't want to read this whole thing, I just have a question!!!](#i-dont-want-to-read-this-whole-thing-i-just-have-a-question)
* [What should I know before I get started?](#what-should-i-know-before-i-get-started)
    * [Environment Setup](#environment-setup)
        * [SDKMAN Setup](#sdkman-setup)
    * [Development Loop](#development-loop)
    * [Module Conventions](#module-conventions)
* [How Can I Contribute?](#how-can-i-contribute)
    * [Reporting Bugs](#reporting-bugs)
        * [Before Submitting A Bug Report](#before-submitting-a-bug-report)
        * [How Do I Submit A (Good) Bug Report?](#how-do-i-submit-a-good-bug-report)
    * [Suggesting Enhancements](#suggesting-enhancements)
        * [How Do I Submit A (Good) Enhancement Suggestion?](#how-do-i-submit-a-good-enhancement-suggestion)
    * [Your First Code Contribution](#your-first-code-contribution)
    * [Pull Requests](#pull-requests)
* [Styleguides](#styleguides)
    * [Git Commit Messages](#git-commit-messages)
    * [Kotlin Styleguide](#kotlin-styleguide)
    * [Sandbox Styleguide](#sandbox-styleguide)

## Code of Conduct

This project and everyone participating in it is governed by the [Code of Conduct](./CODE_OF_CONDUCT.md). By
participating, you are expected to uphold this code. Please report unacceptable behavior
to [martynas@petuska.dev](mailto:martynas@petuska.dev).

## I don't want to read this whole thing I just have a question!!!

> **Note:** Please don't file an issue to ask a question. You'll get faster results by using the resources below.

* [Github Discussions][discussions]
* [Slack Chat][slack]

## What should I know before I get started?

Here are some basic guidelines how to get you up and running with KMDC development quickly. For more detailed tips and
tricks learned from past development refer to a [dedicated page](./TIPS_N_TRICKS.md).

### Environment Setup

KMDC is built with Gradle. However, thanks to gradle wrapper, gradle itself is not required to get going, leaving JDK as
the only prerequisite. For consistency, JDK 11+ is recommended, which can easily be installed via [SDKMAN!][sdkman].

#### SDKMAN Setup

The repository comes with [.sdkmanrc](../.sdkmanrc) file, which configures required JDK tooling semi-automatically,
provided that [SDKMAN!][sdkman] itself is installed. Upon first checkout, run `sdk env install` to get sdkman to install
required tooling. After that, each time you visit the repository in a new terminal, simply run `sdk env` to switch the
terminal session to appropriate JDK tooling. This can be further automated by setting `sdkman_auto_env=true`
in `~/.sdkman/etc/config`.

### Development Loop

To work on UI component library such as KMDC, you obviously need to somehow render your changes to see if they are
correct and work properly. This is achieved with the help of a [sandbox](../sandbox) module. In most of the caxses, the
development loop for KMDC looks as follows:

1. Implement your changes or new features
2. Add a new [Sample](../sandbox/src/jsMain/kotlin/samples/Button.kt) to either one of the existing samples for a
   component or an entirely new samples bundle.
3. Boot up the sandbox in continuous mode `./gradlew jsBrowserRun -t`
4. Inspect your sample in the browser [http://localhost:3000](http://localhost:3000)
5. Make further changes and save the file
6. Wait for your changes to magically rebuild and refresh (takes around 5s)
7. Rinse and repeat

### Module Conventions

There are a few conventions that new modules should follow to maintain consistency:

* Module names should be prefixed with `kmdc-` and use `kebab-case`.
* If a module is wrapping some npm module (such as `kmdc-button`, which wraps `mdc-button` npm module), the name should
  match npm module's name, replacing `mdc-` prefix with `kmdc-` if it has one.
* No wrapper module should depend on more than one npm module
* All modules should be placed in [lib](../lib) meta-module to be picked up as a dependency by root module shortcut
  artefact.

## How Can I Contribute?

### Reporting Bugs

This section guides you through submitting a bug report for KMDC. Following these guidelines helps maintainers and the
community understand your report :pencil:, reproduce the behavior :computer:, and find related reports :mag_right:.

Before creating bug reports, please check [this list][bugs] as you might find out that you don't need to create one.
When you are creating a bug report, please include as many details as possible, especially browser console logs, gradle
logs or relevant code snippets. There's no issue template in use here, to avoid forcing you to fit your issue report
into potentially unhelpful structure for your bug.

> **Note:** If you find a **Closed** issue that seems like it is the same thing that you're experiencing,
> open a new issue and include a reference to the original issue ID (e.g. #1) in the body of your new one.

#### Before Submitting A Bug Report

* **Check the [discussions]** for a list of common questions and problems.
* **Perform a [cursory search][cursory-search]** to see if the problem has already been reported. If it has **and the
  issue is still open**, add a comment to the existing issue instead of opening a new one.

#### How Do I Submit A (Good) Bug Report?

Bugs are tracked as [GitHub issues](https://guides.github.com/features/issues/). After you've determined which KMDC
module your bug is related to, create an issue as many relevant details as you can.

Explain the problem and include additional details to help maintainers reproduce the problem:

* **Use a clear and descriptive title** for the issue to identify the problem.
* **Describe the exact steps which reproduce the problem** in as many details as possible. For example, start by
  explaining how you started your app, e.g. which command exactly you used in the terminal, or how you started your app
  through IntelliJ. When listing steps, **don't just say what you did, but explain how you did it**. For example, if you
  started your app via IntelliJ, explain if you used the gutter run icon, gradle task menu or a custom IntelliJ task
  altogether, and if so which one?
* **Provide specific examples to demonstrate the steps**. Include links to files or GitHub projects, or copy/pasteable
  snippets, which you use in those examples. If you're providing snippets in the issue,
  use [Markdown code blocks](https://help.github.com/articles/markdown-basics/#multiple-lines)
  or [file attachments](https://help.github.com/articles/file-attachments-on-issues-and-pull-requests/).
* **Describe the behavior you observed after following the steps** and point out what exactly is the problem with that
  behavior.
* **Explain which behavior you expected to see instead and why.**
* **Include screenshots and animated GIFs** which show you following the described steps and clearly demonstrate the
  problem. If you use the keyboard while following the steps. You can use [licecap](https://www.cockos.com/licecap/) to
  record GIFs on macOS and Windows, and [silentcast](https://github.com/colinkeenan/silentcast)
  or [byzanz](https://github.com/GNOME/byzanz) on Linux.
* **If the problem wasn't triggered by a specific action**, describe what you were doing before the problem happened and
  share more information using the guidelines below.

Provide more context by answering these questions:

* **Did the problem start happening recently** (e.g. after updating to a new version of KMDC) or was this always a
  problem?
* If the problem started happening recently, **can you reproduce the problem in an older version of KMDC** What's the
  most recent version in which the problem doesn't happen?
* **Can you reliably reproduce the issue?** If not, provide details about how often the problem happens and under which
  conditions it normally happens.

Include details about your configuration and environment:

* **Which version of KMDC are you using?**
* **What's the name and version of the OS you're using**?
* **What's the name and version of the Browser you're using**?
* **Which [modules](../lib) do you have installed?**

### Suggesting Enhancements

This section guides you through submitting an enhancement suggestion for KMDC, including completely new features and
minor improvements to existing functionality. Following these guidelines helps maintainers and the community understand
your suggestion :pencil: and find related suggestions :mag_right:.

Before creating enhancement suggestions, please check [this list][enhancements] as you might find out that you don't
need to create one. When you are creating an enhancement suggestion,
please [include as many details as possible](#how-do-i-submit-a-good-enhancement-suggestion), including the steps that
you imagine you would take if the feature you're requesting existed.

#### How Do I Submit A (Good) Enhancement Suggestion?

Enhancement suggestions are tracked as [GitHub issues][gh-issues]. After you've determined which KMDC module your
enhancement suggestion is related to, create an issue and provide the following information:

* **Use a clear and descriptive title** for the issue to identify the suggestion.
* **Provide a step-by-step description of the suggested enhancement** in as many details as possible.
* **Provide specific examples to demonstrate the steps**. Include links to files or GitHub projects, or copy/pasteable
  snippets, which you use in those examples. If you're providing snippets in the issue,
  use [Markdown code blocks][md-code-blocks]
  or [file attachments][gh-file-attachments].
* **Describe the current behavior** and **explain which behavior you expected to see instead** and why.
* **Include screenshots and animated GIFs** which help you demonstrate the steps or point out the part of KMDC which the
  suggestion is related to. You can use [licecap] to record GIFs on macOS and Windows, and [silentcast] or [byzanz] on
  Linux.
* **Explain why this enhancement would be useful** to most KMDC users and isn't something that can or should be
  implemented as a separate library.
* **List some other JS or Kotlin component libraries where this enhancement exists.**
* **Specify which version of KMDC you're using.**
* **Specify the name and version of the OS you're using.**
* **Specify the name and version of the Browser you're using.**

### Your First Code Contribution

Unsure where to begin contributing to KMDC? You can start by looking through these `good first issue` and `help-wanted`
issues:

* [Good First Issue issues][good-first-issue] - issues which should only require a few lines of code, and a test or two.
* [Help wanted issues][help-wanted] - issues which should be a bit more involved than `good first issue` issues.

Both issue lists are sorted by total number of comments. While not perfect, number of comments is a reasonable proxy for
impact a given change will have.

### Pull Requests

The process described here has several goals:

- Maintain KMDC quality
- Fix problems that are important to users
- Engage the community in working toward the best possible KMDC
- Enable a sustainable system for KMDC's maintainers to review contributions

Please follow these steps to have your contribution considered by the maintainers:

1. Use concise and descriptive PR titles.
2. Provide a short summary of your changes in PR description.
3. Make sure to note any related issues that your PR solves (e.g. `Closes #69`) in the description.
4. Avoid multiple unrelated changes in a single PR. Each PR should have a clear change purpose.
5. Follow the [styleguides](#styleguides)
6. After you submit your pull request, verify that all [status checks][gh-status-checks] are passing
   <details>
     <summary>What if the status checks are failing?</summary>
     If a status check is failing, and you believe that the failure is unrelated to
     your change, please leave a comment on the pull request explaining why you believe the failure is unrelated. A
     maintainer will re-run the status check for you. If we conclude that the failure was a false positive, then we will
     open an issue to track that problem with our status check suite.
   </details>

While the prerequisites above must be satisfied prior to having your pull request reviewed, the reviewer(s) may ask you
to complete additional design work, tests, or other changes before your pull request can be ultimately accepted. On the
other hand, reviewers are also people and aren;t perfect, so feel free to challenge them if you don't agree with
requested change. When doing so, however, please provide constructive reasoning why you believe your approach is better
suited for the problem.

## Styleguides

### Git Commit Messages

* Use the present tense ("Add feature" not "Added feature")
* Use the imperative mood ("Move cursor to..." not "Moves cursor to...")
* Limit the first line to 72 characters or less
* Reference issues and pull requests liberally after the first line
* When only changing documentation, include `[ci skip]` in the commit title
* Consider starting the commit message with an applicable emoji:
    * :art: `:art:` when improving the format/structure of the code
    * :racehorse: `:racehorse:` when improving performance
    * :non-potable_water: `:non-potable_water:` when plugging memory leaks
    * :memo: `:memo:` when writing docs
    * :penguin: `:penguin:` when fixing something on Linux
    * :apple: `:apple:` when fixing something on macOS
    * :checkered_flag: `:checkered_flag:` when fixing something on Windows
    * :bug: `:bug:` when fixing a bug
    * :fire: `:fire:` when removing code or files
    * :green_heart: `:green_heart:` when fixing the CI build
    * :white_check_mark: `:white_check_mark:` when adding tests
    * :lock: `:lock:` when dealing with security
    * :arrow_up: `:arrow_up:` when upgrading dependencies
    * :arrow_down: `:arrow_down:` when downgrading dependencies
    * :shirt: `:shirt:` when removing linter warnings

### Kotlin Styleguide

All JavaScript code is linted with [ktlint][ktlint] via `./gradlew spotlessApply spotlessCheck`. Both tasks are also run
on commit and push git hooks respectively.

In general, KMDC uses [Official Kotlin Coding Conventions][kotlin-coding-conventions] with few minor deviations.
Furthermore, all formatting is automated with ktlint, so you can code in whatever style you wish, as long as you
remember to run `./gradlew spotlessApply` before committing your changes. To make it even
easier, [Ktlint IDEA Plugin][ktlint-idea] is highly recommended.

* Use 2-space indent
* Prefer explicit imports over star imports
* When invoking functions with a big argument list, consider using named arguments
* Try to have as little `public` API as you can, deferring to `private` or `internal` members where possible

### Sandbox Styleguide

Since sandbox is used as a main way to "test" changes in development as well as to showcase the implemented components,
some structure is imposed on its usage to keep everything tidy and easy to navigate.

* Each use-case or component should have its own dedicated samples file
  in [sandbox/src/jsMain/kotlin/samples](../sandbox/src/jsMain/kotlin/samples)
* No changes should be made in the sandbox outside of `samples` package as the ad-hock samples framework is configured
  to register and render all samples in a proper layout automagically.
* All top-level entities in samples file should be private to avoid polluting public namespace.
* While `Samples("name")` container must be named, inner `Sample()` blocks can be anonymous (although it's preferred to
  have them named as well).
* Both `Samples()` and `Sample()` builders also accept optional description argument. Use it to provide some
  instructions or extended usage description of your sample (
  e.g. [checkbox](../sandbox/src/jsMain/kotlin/samples/Checkbox.kt#L35) sample).
* Neither samples file nor top level value names do not need to match the name passed in `Samples("name") { ... }`
  builder, so name them whatever you deem sufficiently descriptive.
* The hierarchy is similar to jest test hierarchy, where a single feature is encapsulated in `describe`
  block (`Samples` block in KMDC) and fine-grained variations are provided by inner `it` blocks (`Sample` block in KMDC)
* State can live at the root of `Samples` block, but target composables should always be encapsulated in `Sample`
  block(s).

Here's an example of the `Samples` adhering to the above conventions:

```kotlin
@Suppress("unused")
private val ButtonSamples = Samples("MDCButton") { // `Samples()` is named to indicate which composable is being used
  MDCButtonOpts.Type.values().forEach {
    Sample("$it") { _ -> // Easily generates definitive list of `Sample()` for all possible values of MDCButton type, using it as a sample name
      var count by remember { mutableStateOf(0) } // State lives within the sample as it needs to be unique for each sample in this case
      MDCButton( // Composable is rendered withing `Sample()` scope as opposed to root `Samples()`
        text = "Clicked $count times",
        opts = { type = it },
        attrs = { onClick { count++ } } // Sample provides some interactivity to showcase usage
      )
    }
  }
}
```

[sdkman]: https://sdkman.io/install/

[ktlint]: https://ktlint.github.io/

[ktlint-idea]: https://plugins.jetbrains.com/plugin/15057-ktlint-unofficial-

[kotlin-coding-conventions]: https://kotlinlang.org/docs/coding-conventions.html

[gh-status-checks]: https://help.github.com/articles/about-status-checks/

[gh-issues]: https://guides.github.com/features/issues/

[gh-file-attachments]: https://help.github.com/articles/file-attachments-on-issues-and-pull-requests/

[md-code-blocks]: https://help.github.com/articles/markdown-basics/#multiple-lines

[licecap]: https://www.cockos.com/licecap/

[silentcast]: https://github.com/colinkeenan/silentcast

[byzanz]: https://github.com/GNOME/byzanz

[slack]: https://kotlinlang.slack.com/team/UL1A5BA2X

[discussions]: https://github.com/mpetuska/kmdc/discussions

[cursory-search]: https://github.com/search?q=+is%3Aissue+repo%3Ampetuska/kmdc

[bugs]: https://github.com/mpetuska/kmdc/issues?q=is%3Aopen+is%3Aissue+label%3Abug

[enhancements]: https://github.com/mpetuska/kmdc/issues?q=is%3Aopen+is%3Aissue+label%3Aenhancement

[good-first-issue]:https://github.com/mpetuska/kmdc/issues?q=is%3Aopen+is%3Aissue+label%3A%22good+first+issue%22+sort%3Acomments-desc

[help-wanted]:https://github.com/mpetuska/kmdc/issues?q=is%3Aopen+is%3Aissue+label%3A%22help+wanted%22+sort%3Acomments-desc
