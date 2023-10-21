import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.LibraryExtension
import com.google.samples.apps.nowinandroid.configureCheckstyle
import com.google.samples.apps.nowinandroid.configureKotlinAndroid
import com.google.samples.apps.nowinandroid.disableUnnecessaryAndroidTests
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.quality.CheckstyleExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
        apply("checkstyle")
      }

      extensions.configure<LibraryExtension> {
        configureKotlinAndroid(this)
        defaultConfig.targetSdk = 34
      }
      extensions.configure<LibraryAndroidComponentsExtension> {
        disableUnnecessaryAndroidTests(target)
      }
      extensions.configure<CheckstyleExtension> {
        configureCheckstyle(this)
      }
      dependencies {
        add("testImplementation", kotlin("test"))
        add("androidTestImplementation", kotlin("test"))
      }
    }
  }
}
