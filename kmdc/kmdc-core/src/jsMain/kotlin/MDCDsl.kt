package dev.petuska.kmdc.core

@DslMarker
@MDCInternalDsl
public annotation class MDCDsl

@DslMarker
@MDCInternalDsl
public annotation class MDCAttrsDsl

@DslMarker
@MDCInternalDsl
@RequiresOptIn("Marks DSL that's used internally by KMDC modules and does not provide any stability guarantees.")
public annotation class MDCInternalDsl
