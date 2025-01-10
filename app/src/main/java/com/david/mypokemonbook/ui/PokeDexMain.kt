package com.david.mypokemonbook.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.david.mypokemonbook.navigation.PokeDexNavHost
import com.david.mypokemonbook.ui.theme.MyPokemonBookTheme

@Composable
fun PokeDexMain() {
    MyPokemonBookTheme {
        val navHostController = rememberNavController()
        PokeDexNavHost(navHostController)
    }
}