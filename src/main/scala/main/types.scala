package main

import scala.annotation.targetName

object Orchard:
  opaque type Ordinal = Int
  opaque type Cardinal = Int

  // todo delete Cardinal altogether
  given Conversion[Int, Cardinal] with
    inline def apply(i: Int): Cardinal = i
  given Conversion[Cardinal, Int] with
    inline def apply(i: Cardinal): Int = i

  inline def cardinal(i: Int): Cardinal = i

  val first: Ordinal = 0
  val second: Ordinal = 1
  val third: Ordinal = 2
  val fourth: Ordinal = 3
  val fifth: Ordinal = 4
  val sixth: Ordinal = 5
  val seventh: Ordinal = 6
  val eighth: Ordinal = 7
  val ninth: Ordinal = 8
  val tenth: Ordinal = 9

  @targetName("beforeOrdinal") inline def before(i: Ordinal): Cardinal = i
  @targetName("afterOrdinal") inline def after(i: Ordinal): Cardinal = i + 1
  @targetName("beforeCardinal") inline def before(i: Cardinal): Ordinal = i - 1
  @targetName("afterCardinal") inline def after(i: Cardinal): Ordinal = i

  extension (i: 1)
    inline def st: Ordinal = 0
  extension (i: 2)
    inline def nd: Ordinal = 1
  extension (i: 3)
    inline def rd: Ordinal = 2
  extension (i: Int)
    inline def th: Ordinal = i - 1

  extension (i: Ordinal)
    @targetName("ordinal+") inline def + (j: Cardinal): Ordinal = i + j
    @targetName("ordinal-") inline def - (j: Cardinal): Ordinal = i - j

  extension (i: Cardinal)
    @targetName("cardinalAsInt") inline def asInt: Int = i
    @targetName("cardinal+") inline def + (j: Cardinal): Cardinal = i + j
    @targetName("cardinal-") inline def - (j: Cardinal): Cardinal = i - j
    inline def * (j: Cardinal): Cardinal = i * j
    inline def / (j: Cardinal): Cardinal = i / j
    inline def % (j: Cardinal): Cardinal = i % j
    inline def unary_- : Cardinal = -i
end Orchard
