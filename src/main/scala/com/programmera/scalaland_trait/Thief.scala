package com.programmera.scalaland_trait

trait Thief extends Professional {

  override def toString = super.toString + "\n is a thief."

  // Good climber
  override def climb = {
    strength + DieRoll.roll(1)
  }
}
  


