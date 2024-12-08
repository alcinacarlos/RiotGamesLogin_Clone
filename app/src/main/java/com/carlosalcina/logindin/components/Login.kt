package com.carlosalcina.logindin.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.carlosalcina.logindin.viewmodel.LoginViewModel

@Composable
fun Login(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    Column(
        modifier = modifier
    ) {
        Header()
        BodyLogin(loginViewModel, navController)
    }
}