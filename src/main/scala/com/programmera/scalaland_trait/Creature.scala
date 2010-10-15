package com.programmera.scalaland_trait

class DeathException(mess: String) extends Exception(mess)

object CreatureFeature extends Enumeration {
   val Strength, Wisdom, Charisma = Value
}

trait Creature {

  // Abstract field
  val name: String

  // Fields
  private var m_strength = 0
  private var m_wisdom = 0
  private var m_charisma = 0
  private var m_hitpoints = 0

  // Setters and Getters 
  def strength = m_strength 
  def strength_=(s: Int) { m_strength = s}
  def wisdom = m_wisdom 
  def wisdom_=(w: Int) { m_wisdom = w}
  def charisma = m_charisma 
  def charisma_=(c: Int) { m_charisma = c}
  def hitpoints= m_hitpoints 
  def hitpoints_=(h: Int) { 
    println("Hitpoints, old value: " + hitpoints + ", new value: " + h)
    if(h > 0)
      m_hitpoints = h
    else
      throw new DeathException(name + " died!")
  }
 
  // Called during initialization of the instance
  protected def generateCreatureFeatures(): Unit = {
    throw new IllegalArgumentException("Creature has no race! " +
      "You must mix in a race during instanciation.")
  }

  // Top level implemenentation, no need to call super
  override def toString = """Creature: %s
    |(strength: %d, wisdom: %d, charisma: %d) hitpoints: %d """.
    stripMargin.
    format(name, m_strength, m_wisdom, m_charisma, m_hitpoints)
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



