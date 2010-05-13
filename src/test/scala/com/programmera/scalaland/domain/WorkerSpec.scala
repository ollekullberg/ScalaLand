package com.programmera.scalaland.domain

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class WorkerSpec extends FlatSpec with ShouldMatchers {
  
  "A Worker" should "be constructed with a list of Roles" in {
    val roleList = List(new Architect(new SkillLevel(1),2), new Programmer(new SkillLevel(3),))
  }
}
