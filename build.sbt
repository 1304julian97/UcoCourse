ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "UcoCourse"
  )


libraryDependencies ++= Seq(
  compilerPlugin("com.softwaremill.neme" %% "neme-plugin" % "0.0.5")
)
