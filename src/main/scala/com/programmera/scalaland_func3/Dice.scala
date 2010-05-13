package com.programmera.scalaland_func3

import scala.Math

object Dice{
  def roll(nrOfDices: Int): Int = {
    require(nrOfDices > 0)
    buildResultSeq(nrOfDices).reduceLeft(_ + _)
  }

  private def buildResultSeq(nrOfDices: Int) = {
    for(i <- 1 to nrOfDices)
      yield new Dice().result
  }
}

class Dice {
  val result = (6 * Math.random + 1).toInt
}

