package com.programmera.scalaland_func5

object Dice{
  private val rnd = new scala.util.Random

  def roll = rnd.nextInt(6) + 1

  def roll(noDice: Int): Int = {
    require(noDice > 0, "noDice must be larger than 0")
    (1 to noDice).view map(_ => roll) sum
  }
}


