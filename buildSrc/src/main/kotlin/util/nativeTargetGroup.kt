package util

import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

fun KotlinMultiplatformExtension.nativeTargetGroup(
  name: String,
  vararg targets: KotlinNativeTarget
): Array<out KotlinNativeTarget> {
  sourceSets {
    val (main, test) = if (targets.size > 1) {
      val nativeMain = getByName("nativeMain")
      val nativeTest = getByName("nativeTest")
      val main = create("${name}Main") {
        dependsOn(nativeMain)
      }
      val test = create("${name}Test") {
        dependsOn(nativeTest)
      }
      main to test
    } else (null to null)
    
    targets.forEach { target ->
      main?.let {
        target.compilations["main"].defaultSourceSet {
          dependsOn(main)
        }
      }
      test?.let {
        target.compilations["test"].defaultSourceSet {
          dependsOn(test)
        }
      }
    }
  }
  return targets
}
