package dev.petuska.kmdc.core

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE)
@DslMarker
@KMDCInternalAPI
public annotation class MDCContentDsl

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE)
@DslMarker
@KMDCInternalAPI
public annotation class MDCAttrsDsl

@DslMarker
@KMDCInternalAPI
@RequiresOptIn(
  message = "This API is used internally by KMDC modules and does not provide any stability guarantees.",
  level = RequiresOptIn.Level.ERROR,
)
public annotation class KMDCInternalAPI

@DslMarker
@RequiresOptIn(
  message = "This API is linking to the external MDC APIs and does not provide any stability guarantees.",
  level = RequiresOptIn.Level.WARNING,
)
public annotation class MDCExternalAPI
