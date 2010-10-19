package com.programmera.scalaland_immutable3

case class Npc(
    val name: String,
    optionalFeatures: Option[CreatureFeatureSet]
  ) extends Creature {

  // Initialize class
  protected val features: CreatureFeatureSet =
    optionalFeatures.getOrElse(generateCreatureFeatures())

  // Private helper method used to update a feature 
  private def updateCreatureFeature( newFeatures: CreatureFeatureSet
      ): Npc = {
    Npc(newFeatures, this)
  }

  // Setters
  def updateStrength(s: Int): Npc =
    updateCreatureFeature(features.copy(strength = s))
  def updateWisdom(w: Int): Npc =
    updateCreatureFeature(features.copy(wisdom = w))
  def updateCharisma(c: Int): Npc =
    updateCreatureFeature(features.copy(charisma = c))
  def updateHitpoints(h: Int): Npc = {
    println("setHitpoints() old value: " + hitpoints + ", new value: " + h)
    if(h > 0)
      updateCreatureFeature(features.copy(hitpoints = h))
    else
      throw new DeathException(name + " died!")
  }

}

object Npc{
  // Used when the avatar already exists
  def apply( newFeatures: CreatureFeatureSet, npc: Npc): Npc =
    npc match {
      case e: Elf   => new Npc(npc.name, Some(newFeatures)) with Elf
      case d: Dwarf => new Npc(npc.name, Some(newFeatures)) with Dwarf
      case _        => throw new Exception("Unknown race: " + npc.name)
    }
}


