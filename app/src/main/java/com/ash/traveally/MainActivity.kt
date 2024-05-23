package com.ash.traveally

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ash.traveally.ui.screens.LoginScreen
import com.ash.traveally.ui.screens.MainScreen
import com.ash.traveally.ui.screens.RegisterScreen
import com.ash.traveally.ui.screens.StartPagerScreen
import com.ash.traveally.ui.theme.TraveallyTheme
import com.ash.traveally.utils.Screens.LOGIN_SCREEN
import com.ash.traveally.utils.Screens.MAIN_SCREEN
import com.ash.traveally.utils.Screens.REGISTER_SCREEN
import com.ash.traveally.utils.Screens.START_PAGER_SCREEN
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TraveallyTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN
    ) {
        composable(route = START_PAGER_SCREEN) {
            StartPagerScreen(
                onClick = { navController.navigate(LOGIN_SCREEN) }
            )
        }
        composable(route = LOGIN_SCREEN) {
            LoginScreen(
                onNavigateToMain = { navController.navigate(MAIN_SCREEN) },
                onSignupTextClick = { navController.navigate(REGISTER_SCREEN) }
            )
        }
        composable(route = REGISTER_SCREEN) {
            RegisterScreen(
                onNavigateToLogin = { navController.popBackStack() }
            )
        }
        composable(route = MAIN_SCREEN) {
            MainScreen()
        }
    }
}

