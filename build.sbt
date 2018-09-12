
name:="pack-bug-demo"

enablePlugins(PackPlugin)


val LOG4J_VERSION="2.11.1"

val LOG4J_LIBS = Seq("org.apache.logging.log4j" % "log4j-api" % LOG4J_VERSION,
                     "org.apache.logging.log4j" % "log4j-core" % LOG4J_VERSION,
                     "org.apache.logging.log4j" % "log4j-1.2-api" % LOG4J_VERSION)

lazy val projA=project.settings(libraryDependencies++=LOG4J_LIBS)

lazy val projB=project.dependsOn(projA % "test->test")

lazy val projC=project
                .enablePlugins(PackPlugin)
                .settings(packMain := Map(),packGenerateMakefile := false)
                .dependsOn(projB)
