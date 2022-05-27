package dev.petuska.kmdc.banner

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEventListener
import dev.petuska.kmdc.core.addMdcEventListener
import kotlin.js.Json

public external interface MDCBannerCloseEventDetail {
  public val reason: CloseReason
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCAttrsDsl
public fun MDCBannerAttrsScope.onClosing(listener: MDCEventListener<MDCBannerCloseEventDetail>) {
  addMdcEventListener("MDCBanner:closing", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCAttrsDsl
public fun MDCBannerAttrsScope.onClosed(listener: MDCEventListener<MDCBannerCloseEventDetail>) {
  addMdcEventListener("MDCBanner:closed", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCAttrsDsl
public fun MDCBannerAttrsScope.onOpening(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCBanner:opening", listener)
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-banner)
 */
@MDCAttrsDsl
public fun MDCBannerAttrsScope.onOpened(listener: MDCEventListener<Json>) {
  addMdcEventListener("MDCBanner:opened", listener)
}
