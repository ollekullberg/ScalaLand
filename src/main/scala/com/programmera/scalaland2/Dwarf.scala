package com.programmera.scalaland2

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
