object AndroidX{
    const val core = "androidx.core:core-ktx:${AndroidXVersions.coreKtx}"
    const val uiCompose = "androidx.compose.ui:ui:${AndroidXVersions.compose_version}"
    const val material = "androidx.compose.material:material:${AndroidXVersions.compose_version}"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${AndroidXVersions.compose_version}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${AndroidXVersions.lifecycle}"
    const val activityCompose = "androidx.activity:activity-compose:${AndroidXVersions.activityCompose}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-compose:${AndroidXVersions.viewModelCompose}"
}

object Square {
    const val retrofit = "com.squareup.retrofit2:retrofit:${SquareVersion.retrofit}"
    const val moshi = "com.squareup.retrofit2:converter-moshi:${SquareVersion.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${SquareVersion.loggingInterceptor}"
}

object Location{
    const val locationService = "com.google.android.gms:play-services-location:${LocationVersion.locationService}"
}

object Hilt{
    const val hilt = "com.google.dagger:hilt-android:${HiltVersion.hilt}"
    const val androidCompiler = "com.google.dagger:hilt-android-compiler:${HiltVersion.hilt}"
    const val lifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${HiltVersion.lifecycleViewModel}"
    const val compiler = "androidx.hilt:hilt-compiler:${HiltVersion.compiler}"
    const val navigationCompose = "androidx.hilt:hilt-navigation-compose:${HiltVersion.navigationCompose}"
}

object TestTool{
    const val junit = "junit:junit:${TestToolVersion.junit}"
    const val extJunit = "androidx.test.ext:junit:${TestToolVersion.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${TestToolVersion.espresso}"
    const val composeUiTest ="androidx.compose.ui:ui-test-junit4:${AndroidXVersions.compose_version}"
    const val uitooling = "androidx.compose.ui:ui-tooling:${AndroidXVersions.compose_version}"
    const val desugar = "com.android.tools:desugar_jdk_libs:${TestToolVersion.desugar}"
}