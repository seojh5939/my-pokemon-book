plugins {
    id("com.david.mypokemonbook.library")
    id("com.david.mypokemonbook.hilt")
}

android {
    namespace = "com.david.mypokemonbook.remote"
}

dependencies {
    // coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.test)

    // network
    implementation(libs.sandwich)
    implementation(platform(libs.retrofit.bom))
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.retrofitBundle)
    testImplementation(libs.okhttp.mockwebserver)
    testImplementation(libs.androidx.arch.core.testing)
}