package com.programmera.scalaland5

object CreatureFeature extends Enumeration {
   val Strength, Wisdom, Charisma = Value
}

trait Creature {

  // Abstract field
  val name: String

  // Abstract Setters and getters 
  def strength: Int
  def strength_=(s: Int): Unit 
  def wisdom: Int
  def wisdom_=(w: Int): Unit 
  def charisma: Int 
  def charisma_=(c: Int): Unit
  def hitpoints: Int 
  def hitpoints_=(h: Int): Unit
  
  // Called during initialization of the instance
  protected def generateCreatureFeatures(): Unit = {
    throw new IllegalArgumentException("Avatar has no race! " +
      "You must mix in a race during instanciation.")
  }

  // Top level implemenentation, no need to call super
  override def toString = "Creature: " + name
}

trait Elf extends Creature {
  override protected def generateCreatureFeatures() {
    strength = DieRoll.roll(2)
    wisdom = DieRoll.roll(4)
    charisma = DieRoll.roll(4) 
    hitpoints = strength * 2
  }
  override def toString = super.toString + "\n is an elf."
}

trait Dwarf extends Creature {
  override protected def generateCreatureFeatures() {
    strength = DieRoll.roll(4)
    wisdom = DieRoll.roll(3)
    charisma = DieRoll.roll(2) 
    hitpoints = strength * 2
  }
  override def toString = super.toString + "\n is a dwarf."
}



