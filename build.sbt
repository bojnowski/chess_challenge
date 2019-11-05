import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "ventotto",
      scalaVersion := "2.13.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "ChessChallenge",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )
