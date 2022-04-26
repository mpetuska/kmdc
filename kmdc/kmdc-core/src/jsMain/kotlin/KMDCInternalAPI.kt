package dev.petuska.kmdc.core

@DslMarker
@KMDCInternalAPI
@RequiresOptIn(
  message = "This API is used internally by KMDC modules and does not provide any stability guarantees.",
  level = RequiresOptIn.Level.ERROR,
)
public annotation class KMDCInternalAPI
