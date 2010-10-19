package com.programmera.scalaland_immutable2

// **** Still not fully functional ****
case class Npc(
    val name: String,
    optionalFeatures: Option[CreatureFeatureSet]
  ) extends Creature {

  // Initialize class
  protected val features: CreatureFeatureSet =
    optionalFeatures.getOrElse(generateCreatureFeatures())

  // Private helper method used to update a feature 
  protected def updateCreatureFeature( newFeatures: CreatureFeatureSet
      ): Npc = {
    Npc(newFeatures, this)
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

