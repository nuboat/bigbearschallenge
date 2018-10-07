organization := "in.nuboat"
name := "hangman"
version := "1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.7"

routesGenerator := InjectedRoutesGenerator

libraryDependencies ++= Seq(
  guice
  , "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test
)
