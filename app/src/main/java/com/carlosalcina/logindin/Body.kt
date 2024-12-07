package com.carlosalcina.logindin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlosalcina.logindin.viewmodel.LoginViewModel
import kotlin.math.sin

@Composable
fun Body(loginViewModel: LoginViewModel) {
    val email by loginViewModel.email.observeAsState(initial = "")
    val password by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable by loginViewModel.isLoginEnabled.observeAsState(initial = false)

    val emailError by loginViewModel.emailError.observeAsState(initial = false)
    val passwordError by loginViewModel.passwordError.observeAsState(initial = false)

    val emailFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier.padding(30.dp)
    ) {
        BodyBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignInText()
            Email(
                email = email,
                emailError = emailError,
                onTextChanged = { loginViewModel.onEmailChanged(it) },
                focusRequester = emailFocusRequester
            )
            Password(
                password = password,
                passwordError = passwordError,
                onTextChanged = { loginViewModel.onPasswordChanged(it) },
                focusRequester = passwordFocusRequester
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(
    email: String,
    emailError: Boolean,
    onTextChanged: (String) -> Unit,
    focusRequester: FocusRequester
) {
    val gradientColors = listOf(Color.White, Color.Gray, Color.White, Color.Gray)
    var isFocused by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .background(colorResource(R.color.riotbackground))
            .drawBehind {
                if (isFocused) {
                    val strokeWidth = 2.dp.toPx()
                    val offset = strokeWidth / 2
                    val gradient = Brush.linearGradient(gradientColors)
                    drawRoundRect(
                        brush = gradient,
                        topLeft = Offset(offset, offset),
                        size = Size(size.width - strokeWidth, size.height - strokeWidth),
                        cornerRadius = CornerRadius(15.dp.toPx()),
                        style = Stroke(width = strokeWidth)
                    )
                }
            }
            .padding(6.dp)
    ){
        OutlinedTextField(
            value = email,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .focusRequester(focusRequester)
                .onPreviewKeyEvent { keyEvent ->
                    if (keyEvent.key == Key.Enter && keyEvent.type == KeyEventType.KeyUp) {
                        focusRequester.requestFocus()
                        true
                    } else {
                        false
                    }
                },
            label = {
                Text(
                    text = stringResource(R.string.email),
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.riotletra)
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = "Email",
                    tint = colorResource(id = R.color.purple_200)
                )
            },
            shape = RoundedCornerShape(15.dp),
            isError = emailError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color.White
            )
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(
    password: String,
    passwordError: Boolean,
    onTextChanged: (String) -> Unit,
    focusRequester: FocusRequester
) {
    val gradientColors = listOf(Color.White, Color.Gray, Color.White, Color.Gray)
    var isFocused by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .background(colorResource(R.color.riotbackground))
            .drawBehind {
                if (isFocused) {
                    val strokeWidth = 2.dp.toPx()
                    val offset = strokeWidth / 2
                    val gradient = Brush.linearGradient(gradientColors)
                    drawRoundRect(
                        brush = gradient,
                        topLeft = Offset(offset, offset),
                        size = Size(size.width - strokeWidth, size.height - strokeWidth),
                        cornerRadius = CornerRadius(15.dp.toPx()),
                        style = Stroke(width = strokeWidth)
                    )
                }
            }
            .padding(6.dp)
    ){
        OutlinedTextField(
            value = password,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .focusRequester(focusRequester)
                .onPreviewKeyEvent { keyEvent ->
                    if (keyEvent.key == Key.Enter && keyEvent.type == KeyEventType.KeyUp) {
                        focusRequester.requestFocus()
                        true
                    } else {
                        false
                    }
                },
            label = {
                Text(
                    text = stringResource(R.string.password),
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.riotletra)
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Password,
                    contentDescription = "Email",
                    tint = colorResource(id = R.color.purple_200)
                )
            },
            shape = RoundedCornerShape(15.dp),
            isError = passwordError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color.White
            )
        )
    }

}



@Composable
fun SignInText() {
    Text(
        text = stringResource(R.string.signin),
        color = Color.White,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
}