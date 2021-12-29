package dev.petuska.kmdc.core

@DslMarker
public annotation class MDCDsl

@DslMarker
public annotation class MDCAttrsDsl

@DslMarker
@RequiresOptIn("Marks DSL that's used internally by KMDC modules and does not provide any stability guarantees.")
public annotation class MDCInternalDsl
