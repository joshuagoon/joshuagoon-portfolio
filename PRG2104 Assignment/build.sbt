ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.19"

libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.192-R14"

lazy val root = (project in file("."))
  .settings(
    name := "testing-tic"
  )