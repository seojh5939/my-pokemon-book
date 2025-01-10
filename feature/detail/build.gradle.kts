plugins {
    id("com.david.mypokemonbook.feature")
    id("com.david.mypokemonbook.hilt")
}

android {
    namespace = "com.david.mypokemonbook.feature.detail"
}

dependencies {
    implementation(projects.presentation)
}