package com.carlosalcina.logindin

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carlosalcina.logindin.ui.theme.LoginDINTheme
import com.carlosalcina.logindin.viewmodel.LoginViewModel

@Composable
fun Login(modifier: Modifier = Modifier, loginViewModel: LoginViewModel) {
    Column(
        modifier = modifier
    ) {
        Header()
        Body(loginViewModel)
    }
}