plugins {
  id("zxing.android.library")
}

android {
  namespace = "com.google.zxing.client.android.core"
}

dependencies {
  api(libs.zxing.core)
}
