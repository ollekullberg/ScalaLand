package com.programmera.scalaland_immutable2

// **** Still incorrect ****
case class Npc(
    val name: String,
    optionalFeatures: Option[CreatureFeatureSet]) 
  extends Creature {

  // Initialize class
  protected val _features: CreatureFeatureSet =
    optionalFeatures.getOrElse(generateCreatureFeatures)

  // Private helper method used to update a feature 
  protected def withCreatureFeature(
      newFeatures: CreatureFeatureSet): Npc = {
    Npc(newFeatures, this)
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

