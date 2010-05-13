package com.programmera.scalaland5

import scala.Math

object Dice{
  def roll(nrOfDices: Int): Int = {
    require(nrOfDices > 0)
    var sum =0;
    for(i <- 1 to nrOfDices){
      sum += new Dice().result
    }
    sum
  }
}
class Dice {
  val result = (6 * Math.random + 1).toInt
}

