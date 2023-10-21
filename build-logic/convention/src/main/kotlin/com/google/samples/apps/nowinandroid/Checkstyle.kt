package com.google.samples.apps.nowinandroid

import org.gradle.api.Project
import org.gradle.api.plugins.quality.CheckstyleExtension

/**
 * Configure base Kotlin with Android options
 */
internal fun Project.configureCheckstyle(
  checkstyleExtension: CheckstyleExtension,
) {
  checkstyleExtension.apply {
    configFile = rootProject.file("src/checkstyle/checkstyle.xml")
  }
}
