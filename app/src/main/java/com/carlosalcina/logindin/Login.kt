package com.carlosalcina.logindin

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carlosalcina.logindin.ui.theme.LoginDINTheme

@Composable
fun Login(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Header()
        Body()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginDINTheme {
        Login()
    }
}