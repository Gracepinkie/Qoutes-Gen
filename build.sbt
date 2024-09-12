ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "quote-generator-backend",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.10.0",
      "org.typelevel" %% "cats-effect" % "3.5.0",

      "org.http4s" %% "http4s-core" % "0.23.13",
      "org.http4s" %% "http4s-dsl" % "0.23.13",
      "org.http4s" %% "http4s-blaze-server" % "0.23.13",
      "org.http4s" %% "http4s-blaze-core" % "0.23.13",
      "org.http4s" %% "http4s-server" % "0.23.13",
      "org.http4s" %% "http4s-circe" % "0.23.13",

      "io.circe" %% "circe-core" % "0.14.10",
      "io.circe" %% "circe-generic" % "0.14.10",
      "io.circe" %% "circe-parser" % "0.14.10",

      "org.apache.kafka" %% "kafka" % "3.5.1",
      "com.typesafe.akka" %% "akka-http" % "10.2.10"
    )
  )
