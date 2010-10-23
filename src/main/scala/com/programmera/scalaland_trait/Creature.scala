package com.programmera.scalaland_trait

trait Creature {

  // Abstract field
  val name: String

  // Fields
  private var _strength = 0
  private var _wisdom = 0
  private var _charisma = 0
  private var _hitpoints = 0

  // Setters and Getters 
  def strength = _strength 
  def strength_=(s: Int) { _strength = s }
  def wisdom = _wisdom 
  def wisdom_=(w: Int) { _wisdom = w }
  def charisma = _charisma 
  def charisma_=(c: Int) { _charisma = c }
  def hitpoints= _hitpoints 
  def hitpoints_=(h: Int) { 
    println("Hitpoints, old value: " + hitpoints + ", new value: " + h)
    if (h > 0)
      _hitpoints = h
    else
      throw new DeathException(name + " died!")
  }
 
  // Called during initialization of the instance
  protected def generateCreatureFeatures() {
    throw new IllegalArgumentException("Creature has no race! " +
      "You must mix in a race during instanciation.")
  }

  // Top level implemenentation, no need to call super
  override def toString = """Creature: %s
    |(strength: %d, wisdom: %d, charisma: %d) hitpoints: %d """.
    stripMargin.
    format(name, _strength, _wisdom, _charisma, _hitpoints)
}




