package main

import scala.annotation.targetName

object Orchard:
  /** Type for ordinal numbers, used as indices. */
  opaque type Ordinal = Int

  /** Type for cardinal numbers, used as quantities. */
  type Cardinal = Int

  /** Array type that only accepts ordinal indices. */
  opaque type Arr[T] = Array[T]
  extension [T](a: Arr[T])
    inline def apply(i: Ordinal): T = a(i)
    inline def update(i: Ordinal, newValue: T): Unit = a(i) = newValue
    inline def length: Cardinal = a.length
  given [T]: Conversion[Array[T], Arr[T]] with
    inline def apply(a: Array[T]): Arr[T] = a

  // Conversion functions between ordinals and cardinals
  @targetName("beforeOrdinal") inline def before(i: Ordinal): Cardinal = i
  @targetName("afterOrdinal") inline def after(i: Ordinal): Cardinal = i + 1
  @targetName("beforeCardinal") inline def before(i: Cardinal): Ordinal = i - 1
  @targetName("afterCardinal") inline def after(i: Cardinal): Ordinal = i

  extension (i: Ordinal)
    inline def + (j: Int): Ordinal = i + j
    inline def - (j: Int): Ordinal = i - j
    def show: String =
      require(i >= 0)
      val next = i + 1
      next.toString + {
        if next > 3 && next < 21 then "th" else next % 10 match
          case 1 => "st"
          case 2 => "nd"
          case 3 => "rd"
          case _ => "th"
     }

  // Convenience ordinal constants
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
end Orchard
