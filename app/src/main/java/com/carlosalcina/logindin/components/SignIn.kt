package com.carlosalcina.logindin.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.carlosalcina.logindin.viewmodel.LoginViewModel

@Composable
fun SignIn(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    Column(
        modifier = modifier
    ) {
        Header()
        BodySignIn(loginViewModel, navController)
    }
}