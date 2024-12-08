package com.carlosalcina.logindin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.carlosalcina.logindin.R
import com.carlosalcina.logindin.viewmodel.LoginViewModel

@Composable
fun Logged(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    Column(
        modifier = modifier
    ) {
        Header()
        Box(
            modifier = Modifier.padding(30.dp)
        ) {
            BodyBackground()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WelcomeText(text = "Bienvenido ${loginViewModel.email.value}")
                BackButton(navController)
            }
        }
    }
}

@Composable
fun BackButton(navController: NavController) {
    IconButton(
        onClick = { navController.popBackStack() },
        modifier = Modifier.padding(top = 30.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = "Atrás",
            tint = colorResource(id = R.color.white),
            modifier = Modifier.size(40.dp)
        )
    }
}