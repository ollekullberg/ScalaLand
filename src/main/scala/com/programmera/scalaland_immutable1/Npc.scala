package com.programmera.scalaland_immutable1

// **** Incorrect ****
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
    Npc(this.name, Some(newFeatures))
  }
}


