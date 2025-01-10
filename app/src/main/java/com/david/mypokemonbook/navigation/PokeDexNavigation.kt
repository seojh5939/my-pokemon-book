package com.david.mypokemonbook.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.david.mypokemonbook.detail.PokeDexDetail
import com.david.mypokemonbook.home.PokeDexHome

enum class PokeDexScreen {
    Home,
    Detail
}

fun NavGraphBuilder.pokeDexNavigation() {
    composable(PokeDexScreen.Home.name) {
        PokeDexHome()
    }

    composable(PokeDexScreen.Detail.name) {
        PokeDexDetail()
    }
}