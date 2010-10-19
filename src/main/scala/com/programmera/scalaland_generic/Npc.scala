package com.programmera.scalaland_generic

case class Npc(
    val name: String,
    optionalFeatures: Option[CreatureFeatureSet]
  ) extends Creature {

  type SubCreature = Npc

  // Initialize class
  protected val features: CreatureFeatureSet =
    optionalFeatures.getOrElse(generateCreatureFeatures())

  // Private helper method used to update a feature 
  protected def updateCreatureFeature( newFeatures: CreatureFeatureSet
      ): Npc = {
    Npc(name, Some(newFeatures))
  }
}


