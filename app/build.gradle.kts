plugins {
    id("com.david.mypokemonbook.application")
    id("com.david.mypokemonbook.application.compose")
    id("com.david.mypokemonbook.hilt")
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.david.mypokemonbook"

    defaultConfig {
        applicationId = "com.david.mypokemonbook"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AppTestRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }

    hilt {
        enableAggregatingTask = true
    }

    testOptions.unitTests {
        isIncludeAndroidResources = true
        isReturnDefaultValues = true
    }
}

dependencies {
    // projects
    implementation(projects.local)
    implementation(projects.remote)
    implementation(projects.data)
    implementation(projects.domain)
    implementation(projects.presentation)

    // features
    implementation(projects.feature.home)
    implementation(projects.feature.detail)

    // cores
    implementation(projects.core.designsystem)

    // compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.foundation)

    // di
    implementation(libs.hilt.android)
    implementation(libs.hilt.core)
    implementation(libs.androidx.material3.android)
    ksp(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.testing)
    kspAndroidTest(libs.hilt.compiler)

    // unit test
    testImplementation(libs.junit)
    testImplementation(libs.turbine)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.truth)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)
}