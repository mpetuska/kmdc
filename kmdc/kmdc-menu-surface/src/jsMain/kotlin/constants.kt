package dev.petuska.kmdc.menu.surface

import kotlin.experimental.or

/**
 * [JS API](https://github.com/material-components/material-components-web/blob/v13.0.0/packages/mdc-menu-surface/constants.ts)
 */

/**
 * Enum for bits in the {@see dev.petuska.kmdc.menu.surface.Corner) bitmap.
 */
public enum class CornerBit(public val byte: Byte) {
  BOTTOM(1),
  CENTER(2),
  RIGHT(4),
  FLIP_RTL(8),
}

/**
 * Enum for representing an element corner for positioning the menu-surface.
 *
 * The START constants map to LEFT if element directionality is left
 * to right and RIGHT if the directionality is right to left.
 * Likewise END maps to RIGHT or LEFT depending on the directionality.
 */
public enum class Corner(@Suppress("unused") corner: Byte) {
  TOP_LEFT(0),
  TOP_RIGHT(CornerBit.RIGHT.byte),
  BOTTOM_LEFT(CornerBit.BOTTOM.byte),
  BOTTOM_RIGHT(CornerBit.BOTTOM.byte or CornerBit.RIGHT.byte),
  TOP_START(CornerBit.FLIP_RTL.byte),
  TOP_END(CornerBit.FLIP_RTL.byte or CornerBit.RIGHT.byte),
  BOTTOM_START(CornerBit.BOTTOM.byte or CornerBit.FLIP_RTL.byte),
  BOTTOM_END(CornerBit.BOTTOM.byte or CornerBit.RIGHT.byte or CornerBit.FLIP_RTL.byte)
}
