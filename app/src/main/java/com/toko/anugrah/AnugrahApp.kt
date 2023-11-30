package com.toko.anugrah

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.toko.anugrah.ui.navigation.AnugrahNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnugrahApp(navController: NavHostController = rememberNavController()) {
    AnugrahNavHost(navController = navController)
}