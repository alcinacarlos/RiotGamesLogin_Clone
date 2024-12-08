package com.carlosalcina.logindin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.carlosalcina.logindin.R
import com.carlosalcina.logindin.navigation.AppScreen
import com.carlosalcina.logindin.viewmodel.LoginViewModel

@Composable
fun BodyLogin(loginViewModel: LoginViewModel, navController: NavController) {
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
            WelcomeText(text = stringResource(R.string.login))
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
                onPasswordVisibility = { loginViewModel.changePasswordVisibility() },
                onTextChanged = { loginViewModel.onPasswordChanged(it) },
                focusRequester = focusRequester
            )
            KeepLoggedInCheckbox(
                isChecked = rememberLogin,
                onCheckedChange = { loginViewModel.changeRemeberLogin() },
                focusRequester = focusRequester
            )
            SocialMediaButtons()
            LoginButton(
                enabled = isLoginEnable,
                onClick = {navController.navigate(route = AppScreen.LoggedScreen.route)}
            )
            FooterButton(
                question = stringResource(R.string.cantlogin),
                text = stringResource(R.string.signin),
                onClickSignIn = {navController.navigate(route = AppScreen.SingInScreen.route)}
            )
        }
    }
}
