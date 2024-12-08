package com.carlosalcina.logindin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun Footer() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        // Botón de idioma
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray)
                .padding(horizontal = 12.dp, vertical = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "EN",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Primera fila de enlaces
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "ASISTENCIA",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = "AVISO DE PRIVACIDAD",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Segunda fila de enlaces
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "TÉRMINOS DE SERVICIO",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = "PREFERENCIAS DE COOKIES",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Nota al pie
        Text(
            text = "ESTA PÁGINA ESTÁ PROTEGIDA POR HCAPTCHA Y BAJO SU",
            color = Color.White,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "POLÍTICA DE PRIVACIDAD",
                color = Color.White,
                fontSize = 12.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "&",
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "TÉRMINOS DE SERVICIO",
                color = Color.White,
                fontSize = 12.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}
