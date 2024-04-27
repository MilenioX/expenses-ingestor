import sbt.*

object Dependencies {
  val munit		= "org.scalameta"	%% "munit"		% Versions.munit	% Test
  val cats 		= "org.typelevel"	%% "cats-core"		% Versions.cats
  val catsEffect	= "org.typelevel"	%% "cats-effect"	% Versions.catsEffect
  val fs2		= "co.fs2"		%% "fs2-io"		% Versions.fs2
}
