plugins {
    id("com.david.mypokemonbook.library")
    id("com.david.mypokemonbook.library.compose")
}

android {
    namespace = "com.david.mypokemonbook.designsystem"
}

dependencies {
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui)
    api(libs.androidx.ui.tooling)
    api(libs.androidx.ui.tooling.preview)
    api(libs.androidx.compose.animation)
    api(libs.androidx.material3)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
}