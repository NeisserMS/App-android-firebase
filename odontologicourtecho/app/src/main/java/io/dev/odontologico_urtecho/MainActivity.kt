package io.dev.odontologico_urtecho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import io.dev.odontologico_urtecho.ui.theme.OdontologicourtechoTheme
import navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OdontologicourtechoTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}

