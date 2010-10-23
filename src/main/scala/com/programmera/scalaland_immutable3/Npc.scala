package com.programmera.scalaland_immutable3

case class Npc(
    val name: String,
    optionalFeatures: Option[CreatureFeatureSet])
  extends Creature {

  // Initialize class
  protected val _features: CreatureFeatureSet =
    optionalFeatures.getOrElse(generateCreatureFeatures)

  // Private helper method used to update a feature 
  private def withCreatureFeature(
      newFeatures: CreatureFeatureSet): Npc = {
    Npc(newFeatures, this)
  }

  // Setters
  def withStrength(s: Int): Npc =
    withCreatureFeature(_features.copy(strength = s))
  def withWisdom(w: Int): Npc =
    withCreatureFeature(_features.copy(wisdom = w))
  def withCharisma(c: Int): Npc =
    withCreatureFeature(_features.copy(charisma = c))
  def withHitpoints(h: Int): Npc = {
    println("setHitpoints() old value: " + hitpoints + ", new value: " + h)
    if (h > 0)
      withCreatureFeature(_features.copy(hitpoints = h))
    else
      throw new DeathException(name + " died!")
  }

}

object Npc {
  // Used when the avatar already exists
  def apply(newFeatures: CreatureFeatureSet, npc: Npc): Npc =
    // Warning! Hard to manage this code
    npc match {
      case e: Elf   => new Npc(npc.name, Some(newFeatures)) with Elf
      case d: Dwarf => new Npc(npc.name, Some(newFeatures)) with Dwarf
      case _ => throw new Exception("Unknown creature type: " + npc.name)
    }
}


