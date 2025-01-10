import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    `kotlin-dsl`
}

group = "com.david.mypokemonbook.buildlogic"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.kotlinx.serialization.json)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id="com.david.mypokemonbook.application.compose"
            implementationClass ="AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id="com.david.mypokemonbook.application"
            implementationClass ="AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id="com.david.mypokemonbook.library.compose"
            implementationClass ="AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id="com.david.mypokemonbook.library"
            implementationClass ="AndroidLibraryConventionPlugin"
        }
        register("androidHilt") {
            id="com.david.mypokemonbook.hilt"
            implementationClass ="AndroidHiltConventionPlugin"
        }
        register("androidFeature") {
            id="com.david.mypokemonbook.feature"
            implementationClass="AndroidFeatureConventionPlugin"
        }
    }
}