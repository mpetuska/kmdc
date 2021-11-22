plugins {
  id("de.fayard.refreshVersions") version "0.23.0"
  id("com.gradle.enterprise") version "3.7.2"
}

refreshVersions { extraArtifactVersionKeyRules(file("versions.rules")) }

rootProject.name = "kmdc"

include(":test")

include(
    ":lib:kmdc-core",
    ":lib:kmdc-button",
    ":lib:kmdc-card",
    ":lib:kmdc-checkbox",
    ":lib:kmdc-chips",
    ":lib:kmdc-drawer",
    ":lib:kmdc-form-field",
    ":lib:kmdc-icon-button",
    ":lib:kmdc-layout-grid",
    ":lib:kmdc-linear-progress",
    ":lib:kmdc-list",
    ":lib:kmdc-ripple",
    ":lib:kmdc-textfield",
    ":lib:kmdc-top-app-bar",
    ":lib:kmdc-typography",
)
