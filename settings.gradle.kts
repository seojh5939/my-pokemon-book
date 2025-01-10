@file:Suppress("UnstableApiUsage")

include(":data")



include(":core:designsystem")


include(":local")


include(":remote")


include(":presentation")


include(":feature:detail")


include(":feature:home")


pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyPokemonBook"
include(":app")
include(":feature")
include(":core")
include(":domain")
