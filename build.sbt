name := "scala-mapping-json-case-class"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "net.liftweb" %% "lift-json" % "3.4.1",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)