import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.google.samples.apps.nowinandroid.configureCheckstyle
import com.google.samples.apps.nowinandroid.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.quality.CheckstyleExtension
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.application")
        apply("org.jetbrains.kotlin.android")
        apply("checkstyle")
      }

      extensions.configure<ApplicationExtension> {
        configureKotlinAndroid(this)
        defaultConfig.targetSdk = 34
      }
      extensions.configure<ApplicationAndroidComponentsExtension> {

      }
      extensions.configure<CheckstyleExtension> {
        configureCheckstyle(this)
      }
    }
  }
}
