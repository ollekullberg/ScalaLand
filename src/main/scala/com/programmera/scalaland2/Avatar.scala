package com.programmera.scalaland2

abstract class Avatar(val name: String, var strength: Int, 
    var wisdom: Int, var charisma: Int){
  var hitpoints = strength * 2
  override def toString = "Avatar: " + name +
    "\n (strength: "+ strength + ", wisdom: "+ wisdom +
    ", charisma: "+ charisma + ")"
}

class Elf(override val name: String, 
    startingStrength: Int, 
    startingWisdom: Int, 
    startingCharisma: Int) extends 
    Avatar(name, startingStrength, 
    startingWisdom, startingCharisma){
  override def toString = super.toString + "\n is an elf."
}

class Dwarf(override val name: String, 
    startingStrength: Int, 
    startingWisdom: Int, 
    startingCharisma: Int) extends 
    Avatar(name, startingStrength, 
    startingWisdom, startingCharisma){
  override def toString = super.toString + "\n is a dwarf."
}
