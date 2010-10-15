package com.programmera.scalaland3


abstract class Avatar(val name: String, 
    private var m_strength: Int, 
    private var m_wisdom: Int, 
    private var m_charisma: Int){
  var hitpoints = m_strength * 2
  val items = new MagicalItemList()
  
  // Setters and getters 
  def strength = m_strength + items.strengthModifier
  def strength_=(s: Int) { m_strength = s}
  def wisdom = m_wisdom + items.wisdomModifier
  def wisdom_=(w: Int) { m_wisdom = w}
  def charisma = m_charisma + items.charismaModifier
  def charisma_=(c: Int) { m_charisma = c}
  
  override def toString = "Avatar: " + name +
    "\n (strength: "+ m_strength + ", wisdom: "+ m_wisdom +
    ", charisma: "+ m_charisma + ")" +
    "\n"+ items
}

object Elf{
  def apply(name: String) = 
    new Elf(name, 
        startingStrength = DieRoll.roll(2), 
        startingWisdom = DieRoll.roll(4),
        startingCharisma = DieRoll.roll(4) ) 
}

class Elf(override val name: String, 
    startingStrength: Int, 
    startingWisdom: Int, 
    startingCharisma: Int) extends 
    Avatar(name, startingStrength, 
    startingWisdom, startingCharisma){
  override def toString = super.toString + "\n is an elf."
}

object Dwarf{
  def apply(name: String) = 
    new Dwarf(name, 
        startingStrength = DieRoll.roll(4), 
        startingWisdom = DieRoll.roll(3),
        startingCharisma = DieRoll.roll(2) ) 
}

class Dwarf(override val name: String, 
    startingStrength: Int, 
    startingWisdom: Int, 
    startingCharisma: Int) extends 
    Avatar(name, startingStrength, 
    startingWisdom, startingCharisma){
  override def toString = super.toString + "\n is a dwarf."
}


   

