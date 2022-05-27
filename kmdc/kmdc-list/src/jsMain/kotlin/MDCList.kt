package dev.petuska.kmdc.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.petuska.kmdc.core.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLUListElement

@JsModule("@material/list/mdc-list.scss")
public external val Style: dynamic

public enum class MDCListSize(public vararg val classes: String) {
  SingleLine, TwoLine("mdc-deprecated-list--two-line")
}

public enum class MDCListType(public vararg val classes: String) {
  Default,
  Textual("mdc-deprecated-list--textual-list"),
  Avatar("mdc-deprecated-list--avatar-list"),
  Icon("mdc-deprecated-list--icon-list"),
  Image("mdc-deprecated-list--image-list"),
  Thumbnail("mdc-deprecated-list--thumbnail-list"),
  Video("mdc-deprecated-list--video-list"),
}

public enum class MDCListSelection(public val listRole: String?, public val itemRole: String?) {
  Single("listbox", "option"),
  SingleRadio("radiogroup", "radio"),
  MultiCheckbox("group", "checkbox"),
  Multi(null, null),
}

public interface MDCListAttrsScope<T : HTMLElement> : AttrsScope<T>
public interface MDCListScope<T : HTMLElement> : ElementScope<T>

internal val MDCListSelectionLocal = strictCompositionLocalOf<MDCListSelection>()

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCList(
  type: MDCListType = MDCListType.Default,
  size: MDCListSize = MDCListSize.SingleLine,
  selection: MDCListSelection = MDCListSelection.Single,
  dense: Boolean = false,
  wrapFocus: Boolean = false,
  attrs: MDCAttrs<MDCListAttrsScope<HTMLUListElement>>? = null,
  content: MDCContent<MDCListScope<HTMLUListElement>>? = null,
) {
  MDCListLayout(
    type = type,
    size = size,
    dense = dense,
    selection = selection,
    attrs = attrs
  ) {
    MDCProvider(::MDCList, selection) {
      MDCSideEffectNew(selection) {
        singleSelection = selection != MDCListSelection.Multi && selection != MDCListSelection.MultiCheckbox
      }
      MDCStateEffectNew(wrapFocus, MDCList::wrapFocus)
      applyContent(content)
    }
  }
}

@KMDCInternalAPI
@Composable
public fun MDCListLayout(
  type: MDCListType = MDCListType.Default,
  size: MDCListSize = MDCListSize.SingleLine,
  dense: Boolean = false,
  selection: MDCListSelection = MDCListSelection.Single,
  attrs: MDCAttrs<MDCListAttrsScope<HTMLUListElement>>? = null,
  content: MDCContent<MDCListScope<HTMLUListElement>>? = null,
) {
  Style
  Ul(attrs = {
    classes("mdc-deprecated-list")
    classes(size.classes)
    classes(type.classes)
    selection.listRole?.let(::role)
    if (dense) classes("mdc-deprecated-list--dense")
    applyAttrs(attrs)
  }) {
    CompositionLocalProvider(MDCListSelectionLocal provides selection) {
      applyContent(content)
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v14.0.0/packages/mdc-deprecated-list)
 */
@MDCContentDsl
@Composable
public fun MDCNavList(
  type: MDCListType = MDCListType.Default,
  size: MDCListSize = MDCListSize.SingleLine,
  selection: MDCListSelection = MDCListSelection.Single,
  dense: Boolean = false,
  wrapFocus: Boolean = false,
  attrs: MDCAttrs<MDCListAttrsScope<HTMLElement>>? = null,
  content: MDCContent<MDCListScope<HTMLElement>>? = null,
) {
  MDCNavListLayout(
    type = type,
    size = size,
    dense = dense,
    selection = selection,
    attrs = attrs
  ) {
    MDCProvider(::MDCList, selection) {
      MDCSideEffectNew(selection) {
        singleSelection = selection != MDCListSelection.Multi && selection != MDCListSelection.MultiCheckbox
      }
      MDCStateEffectNew(wrapFocus, MDCList::wrapFocus)
      applyContent(content)
    }
  }
}

@KMDCInternalAPI
@Composable
public fun MDCNavListLayout(
  type: MDCListType = MDCListType.Default,
  size: MDCListSize = MDCListSize.SingleLine,
  dense: Boolean = false,
  selection: MDCListSelection = MDCListSelection.Single,
  attrs: MDCAttrs<MDCListAttrsScope<HTMLElement>>? = null,
  content: MDCContent<MDCListScope<HTMLElement>>? = null,
) {
  Style
  Nav(attrs = {
    classes("mdc-deprecated-list")
    classes(size.classes)
    classes(type.classes)
    if (dense) classes("mdc-deprecated-list--dense")
    if (dense) classes("mdc-deprecated-list--dense")
    applyAttrs(attrs)
  }) {
    CompositionLocalProvider(MDCListSelectionLocal provides selection) {
      applyContent(content)
    }
  }
}
