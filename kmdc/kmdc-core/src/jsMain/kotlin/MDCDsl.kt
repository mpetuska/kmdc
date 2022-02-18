package dev.petuska.kmdc.core

@DslMarker
@MDCInternalAPI
public annotation class MDCDsl

@DslMarker
@MDCInternalAPI
public annotation class MDCAttrsDsl

@DslMarker
@MDCInternalAPI
@RequiresOptIn(
  message = "This API is used internally by KMDC modules and does not provide any stability guarantees.",
  level = RequiresOptIn.Level.ERROR,
)
public annotation class MDCInternalAPI
