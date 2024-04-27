import Dependencies.*

val scala3Version = "3.3.1"
val svcVersion = "1.0.0-SNAPSHOT"

val dockerImage = sys.env.getOrElse("JDK_17_DOCKER_IMAGE", s"openjdk:17-jdk-slim-buster")

lazy val commonSettings = Seq(
  scalafmtOnCompile := true
)

lazy val root = project.in(file("."))
  .settings(
    name	:= "expenses-ingestor",
    version	:= svcVersion
  )
  .aggregate(apiService)

val apiService = project.in(file("modules/service"))
  .enablePlugins(JavaAppPackaging)
  .settings(commonSettings)
  .settings(
    name	 		:= "expenses-api",
    scalaVersion 		:= scala3Version,
    Docker / packageName 	:= "expenses-ingestor-svc",
    dockerBaseImage		:= s"$dockerImage",
    dockerExposedPorts		:= Seq(8080),
    dockerAliases		:= Seq(
      dockerAlias.value.withTag(Some(s"$svcVersion"))
    ),
    libraryDependencies ++= Seq(
      munit,
      cats,
      catsEffect,
      fs2
    )
  )
