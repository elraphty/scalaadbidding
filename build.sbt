name := "eskimitask"

version := "0.1"

scalaVersion := "2.13.6"

packageName in Docker := "dockerised-akka-http"
dockerBaseImage := "openjdk:8-jre-alpine"
dockerExposedPorts := Seq(8083)

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)
  .enablePlugins(AshScriptPlugin)

val akkaVersion = "2.6.16"
val akkaHttpVersion = "10.2.6"
val scalaTestVersion = "3.2.8"

libraryDependencies ++=Seq(
  // akka streams
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,

  // akka http
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,

  // testing
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalactic" %% "scalactic" % scalaTestVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion,

  // Cors
  "ch.megard" %% "akka-http-cors" % "1.1.2",
)
