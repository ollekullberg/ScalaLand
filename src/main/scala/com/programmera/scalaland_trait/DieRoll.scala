package com.programmera.scalaland_trait

import scala.math

object DieRoll{
  def roll(noDice: Int): Int = {
    require(noDice > 0, "noDice must be larger than 0")
    var sum = 0
    for(i <- 1 to noDice){
      sum += new DieRoll().result
    }
    sum
  }
}

class DieRoll {
  val result = (6 * math.random + 1).toInt
}

