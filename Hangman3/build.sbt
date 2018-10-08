organization := "in.nuboat"
name := "hangman"
version := "1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.7"

routesGenerator := InjectedRoutesGenerator

libraryDependencies ++= Seq(
  guice
  , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.7"
  , "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

)
