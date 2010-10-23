
package com.programmera

package object scalaland_immutable2 {

  // DieRoll
  type DieRoll = com.programmera.scalaland_immutable1.DieRoll
  val  DieRoll = com.programmera.scalaland_immutable1.DieRoll

  // Magical item
  type MagicalItem = com.programmera.scalaland_immutable1.MagicalItem
  val  MagicalItem = com.programmera.scalaland_immutable1.MagicalItem
  type MagicalItemList = com.programmera.scalaland_immutable1.MagicalItemList
  val  MagicalItemList = com.programmera.scalaland_immutable1.MagicalItemList

  // Creature.scala ------------
  // (Only type import for exceptions)
  type DeathException = com.programmera.scalaland_immutable1.DeathException

  // (Only val import for enums)
  val  CreatureFeature = com.programmera.scalaland_immutable1.CreatureFeature

  type CreatureFeatureSet = com.programmera.scalaland_immutable1.CreatureFeatureSet
  val  CreatureFeatureSet = com.programmera.scalaland_immutable1.CreatureFeatureSet

  // (Only type import for traits)
  type Creature = com.programmera.scalaland_immutable1.Creature
  type Dwarf = com.programmera.scalaland_immutable1.Dwarf
  type Elf = com.programmera.scalaland_immutable1.Elf
}
