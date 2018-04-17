lazy val versions = new {
  val finatra = "18.4.0"
}

lazy val commonSettings = Seq(
  version := "1.0.0",
  organization := "com.abhi",
  scalaVersion := "2.12.4"
)
lazy val thriftIdlSettings = Seq(

)
lazy val thriftCoreSettings = Seq(

)
lazy val thriftIdl  = (project in file("thrift-idl"))
  .settings(
    thriftCoreSettings: _*
  )
  .settings(
    commonSettings: _*
  )
  .settings(
    libraryDependencies ++= Seq(
      "com.twitter" %% "finatra-thrift" % versions.finatra
    )    
  )

lazy val thriftServer = (project in file("thrift-server"))
  .settings(
    commonSettings: _*
  )
  .settings(
    libraryDependencies ++= Seq(
      "com.twitter" %% "finatra-thrift" % versions.finatra
    )    
  )  
  .dependsOn(thriftIdl)

lazy val thriftClient = (project in file("thrift-client"))
  .settings(
    commonSettings: _*
  )
  .settings(
    libraryDependencies ++= Seq(
      "com.twitter" %% "scrooge-core" % "18.4.0"
    )
  )
  .dependsOn(thriftIdl)