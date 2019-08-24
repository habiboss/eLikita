name := """e-Likita"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
)

// https://mvnrepository.com/artifact/org.jooq/jooq
libraryDependencies += "org.jooq" % "jooq" % "3.9.1"

// https://mvnrepository.com/artifact/org.jooq/jooq-meta
libraryDependencies += "org.jooq" % "jooq-meta" % "3.9.1"

// https://mvnrepository.com/artifact/org.jooq/jooq-codegen
libraryDependencies += "org.jooq" % "jooq-codegen" % "3.9.1"
PlayKeys.externalizeResources := false

fork in run := false