package com.programmera.scalaland_immutable1

// **** Not fully functional ****
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
    Npc(this.name, Some(newFeatures))
  }
}


