package dev.petuska.kmdc.menu.surface

import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCEvent
import dev.petuska.kmdc.core.MDCEventHandler

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public val onClosed: MDCEventHandler<MDCMenuSurfaceAttrsScope, MDCMenuSurfaceModule.MDCMenuSurfaceEventDetail> =
  MDCEvent(MDCMenuSurfaceModule.strings.CLOSED_EVENT)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public val onClosing: MDCEventHandler<MDCMenuSurfaceAttrsScope, MDCMenuSurfaceModule.MDCMenuSurfaceEventDetail> =
  MDCEvent(MDCMenuSurfaceModule.strings.CLOSING_EVENT)

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-menu-surface)
 */
@MDCAttrsDsl
public val onOpened: MDCEventHandler<MDCMenuSurfaceAttrsScope, MDCMenuSurfaceModule.MDCMenuSurfaceEventDetail> =
  MDCEvent(MDCMenuSurfaceModule.strings.OPENED_EVENT)
