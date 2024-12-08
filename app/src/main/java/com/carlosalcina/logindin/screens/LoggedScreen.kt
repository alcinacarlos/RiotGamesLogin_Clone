package com.carlosalcina.logindin.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.carlosalcina.logindin.components.Logged
import com.carlosalcina.logindin.components.LoginBackground
import com.carlosalcina.logindin.viewmodel.LoginViewModel

@Composable
fun LoggedScreen(navController: NavController, loginViewModel: LoginViewModel){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LoginBackground()
        Logged(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            loginViewModel = loginViewModel,
            navController = navController
        )
    }
}