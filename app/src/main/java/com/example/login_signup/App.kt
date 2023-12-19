package com.example.login_signup

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.login_signup.ui.screens.HomeScreen
import com.example.login_signup.ui.screens.login.LoginScreen
import com.example.login_signup.ui.screens.signup.SignUpScreen
import com.example.login_signup.ui.screens.WelcomeScreen
import com.example.login_signup.ui.widgets.TopAppBarWidget
import com.example.login_signup.viewmodel.AuthViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

enum class AppScreen(@StringRes val title: Int) {
    Welcome(R.string.hello_welcome),
    Login(R.string.login),
    SignUp(R.string.sign_up),
    Home(R.string.home)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(viewModel: AuthViewModel = viewModel()) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.Welcome.name
    )

    Scaffold(
        topBar = {
            TopAppBarWidget(
                currentScreen,
                canNavigateBack = (navController.previousBackStackEntry != null),
                navigateUp = { navController.navigateUp() }
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = AppScreen.Welcome.name,
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 30.dp),
        ) {
            composable(AppScreen.Welcome.name) {
                WelcomeScreen(
                    loginButtonOnClick = { navController.navigate(AppScreen.Login.name) },
                    signUpOnClick = { navController.navigate(AppScreen.SignUp.name) },
                )
            }
            composable(AppScreen.Login.name) {
                LoginScreen(
                    authViewModel = viewModel,
                    loginButtonOnClick = {
                        coroutineScope.launch {
                            viewModel.loginButtonOnClick(navController)
                        }
                    },
                    signUpOnClick = { navController.navigate(AppScreen.SignUp.name) },
                )
            }
            composable(AppScreen.SignUp.name) {
                SignUpScreen(
                    authViewModel = viewModel,
                    signUpOnClick = {
                        coroutineScope.launch {
                            viewModel.signUpButtonClick(navController)
                        }
                    }
                )
            }
            composable(AppScreen.Home.name) {
                HomeScreen()
            }
        }
    }
}