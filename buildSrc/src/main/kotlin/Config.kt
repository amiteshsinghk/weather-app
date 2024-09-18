import org.gradle.api.JavaVersion

object Config{
    const val compileSdk = 32
    const val minSdk = 26
    const val targetSdk =32
    const val versionCode = 1
    const val  versionName = "1.0"
    const val applicationId = "com.amitesh.weatherapp"
    const val jvmTarget = "1.8"
    val java = JavaVersion.VERSION_1_8
}