package com.chelvie.translateapp.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chelvie.translateapp.R

@Composable
fun DashboardScreen(
    onNavigateTranslate: () -> Unit,
    onNavigateSettings: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            // 🟢 background sesuai light/dark mode
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.my_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(top = 24.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))


        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onNavigateTranslate,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Open Translator")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onNavigateSettings,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Settings")
        }
    }
}
