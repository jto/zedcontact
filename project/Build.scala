import sbt._
import Keys._

object ApplicationBuild extends Build {

    val appName         = "zendcontact"
    val appVersion      = "0.1"

    val appDependencies = Seq("org.scalaz" %% "scalaz-core" % "6.0.RC2")

    val main = PlayProject(appName, appVersion, appDependencies).settings(resolvers += ("Scala Tools Snapshots" at "http://scala-tools.org/repo-snapshots/"))

}
            