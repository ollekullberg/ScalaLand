package com.programmera.scalaland_func_final

object CharacterFeature extends Enumeration{
   val Strength, Wisdom, Charisma = Value 
}

class CharacterFeatureSet(
      val strength: Int, 
      val wisdom: Int, 
      val charisma: Int) {

  override def toString = "(strength: %d, wisdom: %d, charisma: %d)".
    format(strength, wisdom, charisma)
}

class DeathException(mess: String) extends Exception(mess)

trait Race {

  // Abstract members
  val name: String
  protected var features: CharacterFeatureSet 
  val maxHitpoints: Int 
  protected var currentHitpoints: Int 

  // Inspectors
  def strength = features.strength 
  def wisdom = features.wisdom
  def charisma = features.charisma

  def generateFeatures: CharacterFeatureSet = {
    throw new IllegalArgumentException("Avatar has no race! " +
      "You must mix in a race during instanciation.")
  }

  def sufferAttack(calcDamage: (Int, Int) => Int): Unit = {
    println("Hitpoints before attack: "+ currentHitpoints)
    val damage = calcDamage(strength, wisdom)
    currentHitpoints -= damage
    if(currentHitpoints < 1) throw new DeathException(name + " died")
    println("Survived. Remaining hitpoints: "+ currentHitpoints)
  }

  override def toString = "Name: %s \n %s \n hitpoints: %s ".
     format(name, features, currentHitpoints)
}

trait Elf extends Race { 
  override def generateFeatures = new CharacterFeatureSet(
    strength = Dice.roll(2),
    wisdom = Dice.roll(4),
    charisma = Dice.roll(4)
  )

  override def toString = super.toString + "\n is an Elf" 
}

trait Dwarf extends Race { 
  override def generateFeatures = new CharacterFeatureSet(
    strength = Dice.roll(4),
    wisdom = Dice.roll(3),
    charisma = Dice.roll(2)
  )

  override def toString = super.toString + "\n is a Dwarf" 
}

