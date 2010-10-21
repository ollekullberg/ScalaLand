package com.programmera.scalaland_immutable1

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
  protected val m_features: CreatureFeatureSet

  // Abstract metods
  protected def withCreatureFeature(
    newFeatures: CreatureFeatureSet): Creature
 
  // Setters and Getters 
  def strength = m_features.strength 
  def withStrength(s: Int): Creature =
    withCreatureFeature(m_features.copy(strength = s))

  def wisdom = m_features.wisdom 
  def withWisdom(w: Int): Creature =
    withCreatureFeature(m_features.copy(wisdom = w))

  def charisma = m_features.charisma 
  def withCharisma(c: Int): Creature =
    withCreatureFeature(m_features.copy(charisma = c))

  def hitpoints= m_features.hitpoints
  def withHitpoints(h: Int): Creature = {
    println("setHitpoints() old value: " + hitpoints + ", new value: " + h)
    if(h > 0)
      withCreatureFeature(m_features.copy(hitpoints = h))
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
     | %s """.stripMargin.format(name, m_features)

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



