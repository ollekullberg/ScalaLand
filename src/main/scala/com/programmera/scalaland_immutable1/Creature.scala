package com.programmera.scalaland_immutable1

trait Creature {

  // Abstract fields
  val name: String
  protected val _features: CreatureFeatureSet

  // Abstract metods
  protected def withCreatureFeature(
    newFeatures: CreatureFeatureSet): Creature
 
  // Setters and Getters 
  def strength = _features.strength 
  def withStrength(s: Int): Creature =
    withCreatureFeature(_features.copy(strength = s))

  def wisdom = _features.wisdom 
  def withWisdom(w: Int): Creature =
    withCreatureFeature(_features.copy(wisdom = w))

  def charisma = _features.charisma 
  def withCharisma(c: Int): Creature =
    withCreatureFeature(_features.copy(charisma = c))

  def hitpoints= _features.hitpoints
  def withHitpoints(h: Int): Creature = {
    println("setHitpoints() old value: " + hitpoints + ", new value: " + h)
    if (h > 0)
      withCreatureFeature(_features.copy(hitpoints = h))
    else
      throw new DeathException(name + " died!")
  }

  // Called during initialization of the instance
  protected def generateCreatureFeatures: CreatureFeatureSet = {
    throw new IllegalArgumentException("Avatar has no race! " +
      "You must mix in a race during instanciation.")
  }

  // Top level implemenentation, no need to call super
  override def toString = """Creature: %s 
     | %s """.stripMargin.format(name, _features)

}

