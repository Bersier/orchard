package main

import scala.annotation.targetName

object Orchard:
  /**
   * Type for ordinal numbers, used as indices.
   *
   * Ordinals are analogous to points in an affine space.
   */
  opaque type Ordinal = Int

  /**
   * Type for cardinal numbers, used as quantities.
   *
   * Cardinals are analogous to vectors in an affine space.
   */
  type Cardinal = Int

  /** Array type that only accepts ordinal indices. */
  opaque type Arr[T] = Array[T]
  extension [T](a: Arr[T])
    inline def apply(i: Ordinal): T = a(i)
    inline def update(i: Ordinal, newValue: T): Unit = a(i) = newValue
    inline def length: Cardinal = a.length
    inline def indices: IndexedSeq[Ordinal] = arrayIndices(a)
  given [T]: Conversion[Array[T], Arr[T]] with
    inline def apply(a: Array[T]): Arr[T] = a

  extension (i: Cardinal)
    /**
     * @return the next index
     */
    @targetName("cardinalSucc") inline def succ: Ordinal = i
    /**
     * @return the previous index
     */
    @targetName("cardinalPred") inline def pred: Ordinal = i - 1
    /**
     * @return the range that covers all the ordinals between [[i]] and [[j]].
     */
    inline def <-> (j: Cardinal): IndexedSeq[Ordinal] = i until j

  extension (i: Ordinal)
    inline def + (j: Cardinal): Ordinal = i + j
    inline def - (j: Cardinal): Ordinal = i - j
    /**
     * @return the distance between [[i]] and [[j]]
     */
    inline def --> (j: Ordinal): Cardinal = j - i
    /**
     * @return the number of all ordinals (starting from the first) up to and including this one
     */
    @targetName("ordinalSucc") inline def succ: Cardinal = i + 1
    /**
     * @return the number of all ordinals (starting from the first) up to but excluding this one
     */
    @targetName("ordinalPred") inline def pred: Cardinal = i
    def show: String =
      require(i >= 0)
      val next = i + 1
      next.toString + (
        if next > 3 && next < 21 then "th" else next % 10 match
          case 1 => "st"
          case 2 => "nd"
          case 3 => "rd"
          case _ => "th"
      )

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

private[main] inline def arrayIndices(inline array: Array[?]): Range = array.indices
