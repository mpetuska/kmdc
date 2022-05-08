package dev.petuska.kmdc.banner

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler
import kotlin.js.Json

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCAttrsDsl
public val onClosing: MDCEventHandler<MDCBannerAttrsScope, MDCBannerModule.MDCBanner.MDCBannerCloseEventDetail> =
  MDCEvent("MDCBanner:closing")

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCAttrsDsl
public val onClosed: MDCEventHandler<MDCBannerAttrsScope, MDCBannerModule.MDCBanner.MDCBannerCloseEventDetail> =
  MDCEvent("MDCBanner:closed")

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCAttrsDsl
public val onOpening: MDCEventHandler<MDCBannerAttrsScope, Json> =
  MDCEvent("MDCBanner:opening")

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCAttrsDsl
public val onOpened: MDCEventHandler<MDCBannerAttrsScope, Json> =
  MDCEvent("MDCBanner:opened")
