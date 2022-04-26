package dev.petuska.kmdc.core

@DslMarker
@KMDCInternalAPI
@RequiresOptIn(
  message = "This API is linking to the external MDC APIs and does not provide any stability guarantees.",
  level = RequiresOptIn.Level.WARNING,
)
public annotation class MDCExternalAPI
