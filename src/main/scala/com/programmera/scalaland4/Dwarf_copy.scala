package com.programmera.scalaland4

object Dwarf {
  def apply(name: String) = 
    new Dwarf(
      name, 
      startingStrength = DieRoll.roll(4), 
      startingWisdom = DieRoll.roll(3),
      startingCharisma = DieRoll.roll(2) ) 
}

class Dwarf(
    override val name: String, 
    startingStrength: Int, 
    startingWisdom: Int, 
    startingCharisma: Int) 
  extends Avatar(
    name, 
    startingStrength, 
    startingWisdom, 
    startingCharisma) {

  override def toString = super.toString + "\n is a dwarf."
}


   

