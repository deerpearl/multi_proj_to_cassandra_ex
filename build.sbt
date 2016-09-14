name := "multi_cassandra"

version := "1.0"

val commonSettings = Seq(
  organization := "net.example",
  version := "0.1",
  scalaVersion := "2.11.8",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8"),
  libraryDependencies ++= Seq (
    "org.scalatest" %% "scalatest" % "2.2.0" % "test",
    "com.datastax.cassandra" % "cassandra-driver-core" % "3.1.0"
  )
)


/*
lazy val common = project.in(file("common"))
  .settings(commonSettings:_*)
*/

lazy val common: Project = Project(
  id = "common",
  base = file("common")
).settings(commonSettings:_*)

lazy val playApp = project.in(file("playApp"))
  .settings(commonSettings:_*)

lazy val main = project.in(file("."))
  .aggregate(common, playApp)