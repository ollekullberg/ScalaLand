package com.programmera.scalaland_immutable1

import scala.math

object DieRoll {
  def roll(noDice: Int): Int = {
    require(noDice > 0, "noDice must be larger than 0")
    (1 to noDice).map { _ => 
      new DieRoll().result
    }.sum
  }
}

class DieRoll {
  val result = (6 * math.random + 1).toInt
}

