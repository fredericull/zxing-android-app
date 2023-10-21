plugins {
  id("zxing.android.application")
}

android {
  defaultConfig {
    applicationId = "com.google.zxing.client.android"
    versionCode = 109
    versionName = "4.7.9"
  }

  // Update main SourceSet to match existing hierarchy
  sourceSets.getByName("main") {
    // Default "src/main/java"
    java.setSrcDirs(listOf("src"))
    // Default "src/main/AndroidManifest.xml"
    manifest.srcFile("AndroidManifest.xml")
    // Default "src/main/res"
    res.setSrcDirs(listOf("res"))
    // Default "src/main/assets"
    assets.setSrcDirs(listOf("assets"))
  }

  namespace = "com.google.zxing.client.android"
}

dependencies {
  implementation(projects.androidCore)
}
