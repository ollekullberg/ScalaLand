package com.programmera.scalaland.domain

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class RoleSpec extends FlatSpec with ShouldMatchers {

  "A Role" should " return the correct morale reduction" in {
    val arch = new Architect(new SkillLevel(1),2)
    arch.personalMoraleReduction should equal (17)
  }
  
  it should "keep the Skill Level setting given" in {
    val arch = new Architect(new SkillLevel(1),2)
    arch.skillLevel.intLevel should equal (1) 
  }
}
