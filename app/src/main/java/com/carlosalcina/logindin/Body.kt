package com.carlosalcina.logindin

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlosalcina.logindin.viewmodel.LoginViewModel

@Composable
fun Body(loginViewModel: LoginViewModel) {
    val email by loginViewModel.email.observeAsState(initial = "")
    val password by loginViewModel.password.observeAsState(initial = "")

    val rememberLogin by loginViewModel.rememberLogin.observeAsState(initial = false)
    val isLoginEnable by loginViewModel.isLoginEnabled.observeAsState(initial = false)
    val isPasswordVisible by loginViewModel.isPasswordVisible.observeAsState(initial = false)

    val emailError by loginViewModel.emailError.observeAsState(initial = false)
    val passwordError by loginViewModel.passwordError.observeAsState(initial = false)

    val focusRequester = remember { FocusRequester() }

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
            SignInText()
            Email(
                email = email,
                emailError = emailError,
                onTextChanged = { loginViewModel.onEmailChanged(it) },
                focusRequester = focusRequester
            )
            Password(
                password = password,
                passwordError = passwordError,
                isPasswordVisible = isPasswordVisible,
                onPasswordVisibility = {loginViewModel.changePasswordVisibility()},
                onTextChanged = { loginViewModel.onPasswordChanged(it) },
                focusRequester = focusRequester
            )
            KeepLoggedInCheckbox(
                isChecked = rememberLogin,
                onCheckedChange = {loginViewModel.changeRemeberLogin()},
                focusRequester = focusRequester
            )
            SocialMediaButtons()
            LoginButton(
                enabled = isLoginEnable,
                onClick = {}
            )
        }
    }
}

@Composable
fun Email(
    email: String,
    emailError: Boolean,
    onTextChanged: (String) -> Unit,
    focusRequester: FocusRequester
) {
    val gradientColors = listOf(colorResource(R.color.white), colorResource(R.color.gray), colorResource(R.color.white), colorResource(R.color.gray))
    val errorColors = listOf(Color.Red, Color.Red)

    var isFocused by remember { mutableStateOf(false) }

    BoxConDegradado(
        isFocused = isFocused,
        isError = emailError,
        gradientColors = if (emailError) errorColors else gradientColors,
        modifier = Modifier
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .focusRequester(focusRequester)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .focusRequester(focusRequester),
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
            colors = coloresCampos()
        )
    }

}

@Composable
fun Password(
    password: String,
    passwordError: Boolean,
    isPasswordVisible:Boolean,
    onPasswordVisibility: () -> Unit,
    onTextChanged: (String) -> Unit,
    focusRequester: FocusRequester
) {
    val gradientColors = listOf(colorResource(R.color.white), colorResource(R.color.gray), colorResource(R.color.white), colorResource(R.color.gray))
    val errorColors = listOf(Color.Red, Color.Red)
    var isFocused by remember { mutableStateOf(false) }

    BoxConDegradado(
        isFocused = isFocused,
        isError = passwordError,
        gradientColors = if (passwordError) errorColors else gradientColors,
        modifier = Modifier
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .focusRequester(focusRequester)
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .focusRequester(focusRequester),
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
            trailingIcon = {
                IconButton(
                    onClick = { onPasswordVisibility() }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Ocultar contraseña"
                    )
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(15.dp),
            colors = coloresCampos()
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun coloresCampos() = TextFieldDefaults.outlinedTextFieldColors(
    focusedBorderColor = Color.Transparent,
    unfocusedBorderColor = Color.Transparent,
    focusedTextColor = Color.White,
    unfocusedTextColor = Color.White
)

@Composable
fun BoxConDegradado(
    isFocused: Boolean,
    isError: Boolean,
    gradientColors: List<Color>,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .background(colorResource(R.color.riotbackground))
            .drawBehind {
                if (isFocused || isError) {
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
    ) {
        content()
    }
}
@Composable
fun KeepLoggedInCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    focusRequester: FocusRequester
) {
    val isFocused = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            },
        verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { newValue ->
                onCheckedChange(newValue)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(id = R.color.purple_200),
                uncheckedColor = Color.Gray
            )
        )
        Text(
            text = stringResource(id = R.string.keep_logged_in),
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.riotletra)
        )

    }
}

@Composable
fun LoginButton(
    onClick: () -> Unit,
    enabled: Boolean
) {
    IconButton(
        onClick = onClick,
        enabled = enabled,
        colors = IconButtonColors(
            contentColor = colorResource(R.color.white),
            containerColor = colorResource(R.color.loginbutton),
            disabledContainerColor = colorResource(R.color.loginbuttondisabled),
            disabledContentColor =  colorResource(R.color.white)
        ),
        modifier = Modifier
            .size(100.dp)
            .padding(5.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Arrow",
            tint = Color.White
        )
    }
}


@Composable
fun SignInText() {
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = stringResource(R.string.signin),
        color = Color.White,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
}