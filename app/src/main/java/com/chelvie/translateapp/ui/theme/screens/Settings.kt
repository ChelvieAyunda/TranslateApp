package com.chelvie.translateapp.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Switch
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    isDark: Boolean,
    onToggleDark: () -> Unit,
    selectedLang: String,
    onLangChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            // 🟢 background otomatis light/dark mode
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        // 🟢 text ikut warna onBackground biar terbaca di light/dark
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 🟢 Tombol bahasa otomatis style Material3
        Row {
            Button(
                onClick = { onLangChange("en") },
                modifier = Modifier.weight(1f)
            ) {
                Text("English")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { onLangChange("id") },
                modifier = Modifier.weight(1f)
            ) {
                Text("Indonesia")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 🟢 Dark Mode Switch mengikuti theme
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Dark Mode",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Switch(
                checked = isDark,
                onCheckedChange = { onToggleDark() }
            )
        }
    }
}
