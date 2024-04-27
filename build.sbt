import Dependencies.*

val scala3Version = "3.3.1"

lazy val commonSettings = Seq(
  scalafmtOnCompile := true
)

lazy val root = project.in(file("."))
  .settings(
    name	:= "expenses-ingestor",
    version	:= "1.0.0-SNAPSHOT"
  )
  .aggregate(apiService)

val apiService = project.in(file("modules/service"))
  .settings(commonSettings)
  .settings(
    name	 	:= "expenses-api",
    scalaVersion 	:= scala3Version,
    libraryDependencies ++= Seq(
      munit,
      cats,
      catsEffect,
      fs2
    )
  )
