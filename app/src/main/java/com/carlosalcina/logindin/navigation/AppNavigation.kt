package com.carlosalcina.logindin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.carlosalcina.logindin.screens.LoggedScreen
import com.carlosalcina.logindin.screens.LoginScreen
import com.carlosalcina.logindin.screens.SignInScreen
import com.carlosalcina.logindin.viewmodel.LoginViewModel


@Composable
fun AppNavigation(){
    val navControlador = rememberNavController()
    val loginViewModel = LoginViewModel()

    NavHost(navController = navControlador, startDestination = AppScreen.LoginScreen.route) {
        composable(AppScreen.LoginScreen.route){
            LoginScreen(navControlador, loginViewModel)
        }
        composable(AppScreen.LoggedScreen.route){
            LoggedScreen(navControlador, loginViewModel)
        }
        composable(AppScreen.SingInScreen.route){
            SignInScreen(navControlador, loginViewModel)
        }
    }
}