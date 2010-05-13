import sbt._
import de.element34.sbteclipsify._

class ScalaLandProject(info: ProjectInfo) extends DefaultProject(info) 
    with SbtEclipsifyPlugin{

  val scalatest = "org.scalatest" % "scalatest" % "1.0.1-for-scala-2.8.0.Beta1-with-test-interfaces-0.3-SNAPSHOT" % "test" 

 // ------------------------------------------------------------
  // repositories
/*
  val sunjdmk = "sunjdmk" at "http://wp5.e-taxonomy.eu/cdmlib/mavenrepo"
  val databinder = "DataBinder" at "http://databinder.net/repo"
  val configgy = "Configgy" at "http://www.lag.net/repo"
  val codehaus = "Codehaus" at "http://repository.codehaus.org"
  val codehaus_snapshots = "Codehaus Snapshots" at "http://snapshots.repository.codehaus.org"
  val jboss = "jBoss" at "http://repository.jboss.org/maven2"
  val guiceyfruit = "GuiceyFruit" at "http://guiceyfruit.googlecode.com/svn/repo/releases/"
  val google = "google" at "http://google-maven-repository.googlecode.com/svn/repository"
  val m2 = "m2" at "http://download.java.net/maven/2"

  val scalatest = "org.scalatest" % "scalatest" % "1.0" % "test"
*/
  // External dependencies
  //val scalaToolsRepo = "Scala-Tools Maven Repository" at
  //     http://scala-tools.org/repo-releases/
  //val scalaToolsRepo = "Scala-Tools Maven Repository" at
  //    "http://scala-tools.org/repo-releases/org/scala-tools/testing/scalatest/0.9.5/"
  //val scalatest = "org.scala-tools.testing" % "scalatest" % "0.9.5"


}

