import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chelvie.translateapp.ui.screens.dashboard.DashboardScreen
import com.chelvie.translateapp.ui.screens.settings.SettingsScreen
import com.chelvie.translateapp.ui.theme.screens.TranslateScreen

@Composable
fun NavGraph(
    isDark: Boolean,
    onToggleDark: () -> Unit,
    selectedLang: String,
    onLangChange: (String) -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "dashboard"
    ) {

        composable("dashboard") {
            DashboardScreen(
                onNavigateTranslate = { navController.navigate("translate") },
                onNavigateSettings = { navController.navigate("settings") }
            )
        }

        composable("translate") {
            TranslateScreen(
                selectedLang = selectedLang.ifEmpty { "en" }  // 🔥 default biar tidak null
            )
        }

        composable("settings") {
            SettingsScreen(
                isDark = isDark,
                onToggleDark = onToggleDark,
                selectedLang = selectedLang,
                onLangChange = { lang ->
                    onLangChange(lang)
                    navController.popBackStack() // 🔥 biar tidak crash saat berpindah theme/lang
                }
            )
        }
    }
}
