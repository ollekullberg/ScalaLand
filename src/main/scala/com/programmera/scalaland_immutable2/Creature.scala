package com.programmera.scalaland_immutable2

class DeathException(mess: String) extends Exception(mess)

object CreatureFeature extends Enumeration {
   val Strength, Wisdom, Charisma = Value
}

case class CreatureFeatureSet(
    strength: Int,
    wisdom: Int,
    charisma: Int,
    hitpoints: Int) {

  override def toString = 
    "(strength: %d, wisdom: %d, charisma: %d) hitpoints %d".
    format(strength, wisdom, charisma, hitpoints)
}

trait Creature {

  // Abstract fields
  val name: String
  protected val features: CreatureFeatureSet

  // Abstract metods
  protected def updateCreatureFeature(
    features: CreatureFeatureSet): Creature
 
  // Setters and Getters 
  def strength = features.strength 
  def updateStrength(s: Int): Creature =
    updateCreatureFeature(features.copy(strength = s))

  def wisdom = features.wisdom 
  def updateWisdom(w: Int): Creature =
    updateCreatureFeature(features.copy(wisdom = w))

  def charisma = features.charisma 
  def updateCharisma(c: Int): Creature =
    updateCreatureFeature(features.copy(charisma = c))

  def hitpoints= features.hitpoints
  def updateHitpoints(h: Int): Creature = {
    println("setHitpoints() old value: " + hitpoints + ", new value: " + h)
    if(h > 0)
      updateCreatureFeature(features.copy(hitpoints = h))
    else
      throw new DeathException(name + " died!")
  }

  // Called during initialization of the instance
  protected def generateCreatureFeatures(): CreatureFeatureSet = {
    throw new IllegalArgumentException("Avatar has no race! " +
      "You must mix in a race during instanciation.")
  }

  // Top level implemenentation, no need to call super
  override def toString = """Creature: %s 
     | %s """.stripMargin.format(name, features)

}

trait Elf extends Creature {
  override protected def generateCreatureFeatures(): CreatureFeatureSet = {
    val tmpStrength = DieRoll.roll(2)
    CreatureFeatureSet(
      strength = tmpStrength,
      wisdom = DieRoll.roll(4),
      charisma = DieRoll.roll(4),
      hitpoints = tmpStrength * 2)
  }
  override def toString = super.toString + "\n is an elf."
}

trait Dwarf extends Creature {
  override protected def generateCreatureFeatures(): CreatureFeatureSet = {
    val tmpStrength = DieRoll.roll(4)
    CreatureFeatureSet(
      strength = tmpStrength,
      wisdom = DieRoll.roll(3),
      charisma = DieRoll.roll(2),
      hitpoints = tmpStrength * 2)
  }
  override def toString = super.toString + "\n is a dwarf."
}



