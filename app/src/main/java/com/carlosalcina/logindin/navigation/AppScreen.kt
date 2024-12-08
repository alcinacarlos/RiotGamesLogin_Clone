package com.carlosalcina.logindin.navigation

sealed class AppScreen(val route: String) {
    object LoginScreen: AppScreen("LoginScreen")
    object WelcomeScreen: AppScreen("WelcomeScreen")
    object SingInScreen : AppScreen("SingInScreen")
    object LoggedScreen : AppScreen("LoggedScreen")
}