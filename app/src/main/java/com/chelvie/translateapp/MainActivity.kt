// MainActivity.kt
package com.chelvie.translateapp

import NavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import com.chelvie.translateapp.ui.theme.screens.TranslateAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDark by rememberSaveable { mutableStateOf(false) }
            var selectedLang by rememberSaveable { mutableStateOf("id") } // default Indonesian

            TranslateAppTheme(isDark = isDark) {
                NavGraph(
                    isDark = isDark,
                    onToggleDark = { isDark = !isDark },
                    selectedLang = selectedLang,
                    onLangChange = { selectedLang = it }
                )
            }
        }
    }
}
