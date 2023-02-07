package main

@main
def main(): Unit =
  import Orchard.*
  val a: Arr[Int] =
    import scala.language.implicitConversions
    Array(1, 2, 3)
  println(a(first))
  a(second) = 7
  println(a(second))
  println(after(after(first)).show)
