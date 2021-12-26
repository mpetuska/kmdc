package dev.petuska.kmdc.segmented.button

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.core.Builder
import dev.petuska.kmdc.core.ComposableBuilder
import dev.petuska.kmdc.core.MDCAttrsDsl
import dev.petuska.kmdc.core.MDCDsl
import dev.petuska.kmdc.core.mdc
import dev.petuska.kmdc.ripple.MDCRippleModule
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event

@JsModule("@material/segmented-button/dist/mdc.segmented-button.css")
private external val MDCSegmentedButtonStyle: dynamic

@JsModule("@material/segmented-button")
public external object MDCSegmentedButtonModule {
  public class MDCSegmentedButton(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCSegmentedButton
    }

    public val segments: Array<MDCSegmentedButtonSegment>
    public fun initialize(segmentFactory: (el: Element, foundation: dynamic) -> MDCSegmentedButtonSegment = definedExternally)
    public fun initialSyncWithDOM()
    public fun destroy()
    public fun getDefaultFoundation(): dynamic
    public fun getSelectedSegments(): Array<dynamic>
    public fun selectSegment(indexOrSegmentId: dynamic)
    public fun unselectSegment(indexOrSegmentId: dynamic)
    public fun isSegmentSelected(indexOrSegmentId: dynamic): Boolean
  }

  public class MDCSegmentedButtonSegment(element: Element) {
    public companion object {
      public fun attachTo(element: Element): MDCSegmentedButtonSegment
    }

    public var ripple: MDCRippleModule.MDCRipple
    public fun initialize(rippleFactory: (el: Element, foundation: dynamic) -> MDCRippleModule.MDCRipple)
    public fun initialSyncWithDOM()
    public fun destroy()
    public fun getDefaultFoundation(): dynamic
    public fun setIndex(index: Number)
    public fun setIsSingleSelect(isSingleSelect: Boolean)
    public fun isSelected(): Boolean
    public fun setSelected()
    public fun setUnselected()
    public fun getSegmentId(): dynamic
  }

  public interface SegmentDetail {
    public val index: Number
    public val selected: Boolean
    public val segmentId: String?
  }

  public class MDCSegmentedButtonChangeEvent : Event {
    public val detail: SegmentDetail
  }

  public class MDCSegmentedButtonSegmentSelectedEvent : Event {
    public val detail: SegmentDetail
  }
}

public data class MDCSegmentedButtonOpts(
  var singleSelect: Boolean = false,
)

public class MDCSegmentedButtonScope(scope: ElementScope<HTMLDivElement>, internal val opts: MDCSegmentedButtonOpts) :
  ElementScope<HTMLDivElement> by scope {

/**
   * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
   */
  @MDCAttrsDsl
  public fun AttrsBuilder<HTMLButtonElement>.onSegmentSelected(
    listener: (MDCSegmentedButtonModule.MDCSegmentedButtonSegmentSelectedEvent) -> Unit
  ) {
//  TODO Uncomment after https://github.com/material-components/material-components-web/issues/7127 is fixed
//    addEventListener("MDCSegmentedButtonSegment:selected") {
    addEventListener("selected") {
      listener(it.nativeEvent.unsafeCast<MDCSegmentedButtonModule.MDCSegmentedButtonSegmentSelectedEvent>())
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
 */
@MDCDsl
@Composable
public fun MDCSegmentedButton(
  opts: Builder<MDCSegmentedButtonOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCSegmentedButtonScope>? = null
) {
  MDCSegmentedButtonStyle
  val options = MDCSegmentedButtonOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-segmented-button")
      if (options.singleSelect) {
        classes("mdc-segmented-button--single-select")
        attr("role", "radiogroup")
      } else {
        attr("role", "group")
      }
      ref {
        val mdc = MDCSegmentedButtonModule.MDCSegmentedButton.attachTo(it)
        it.mdc = mdc
        onDispose {
          it.mdc<MDCSegmentedButtonModule.MDCSegmentedButton> { destroy() }
        }
      }
      attrs?.invoke(this)
    },
    content = content?.let { { MDCSegmentedButtonScope(this, options).it() } }
  )
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v13.0.0/packages/mdc-segmented-button)
 */
@MDCAttrsDsl
public fun AttrsBuilder<HTMLDivElement>.onSegmentChange(
  listener: (MDCSegmentedButtonModule.MDCSegmentedButtonChangeEvent) -> Unit
) {
//  TODO Uncomment after https://github.com/material-components/material-components-web/issues/7127 is fixed
//  addEventListener("MDCSegmentedButton:change") {
  addEventListener("change") {
    listener(it.nativeEvent.unsafeCast<MDCSegmentedButtonModule.MDCSegmentedButtonChangeEvent>())
  }
}
