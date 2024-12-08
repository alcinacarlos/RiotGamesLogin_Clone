package com.carlosalcina.logindin.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.carlosalcina.logindin.R

@Composable
fun LoginBackground() {
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = "Background image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillHeight
    )
}

@Composable
fun BodyBackground() {
    Image(
        painter = painterResource(id = R.drawable.fondo_login),
        contentDescription = "Background image",
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(18.dp)),
        contentScale = ContentScale.Crop
    )
}