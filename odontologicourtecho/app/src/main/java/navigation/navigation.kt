
package navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import modulo_A.ModuleAScreen
import auth.LoginScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("moduleA") { ModuleAScreen(navController) }
    }
}
