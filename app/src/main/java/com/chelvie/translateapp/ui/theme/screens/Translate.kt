package com.chelvie.translateapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun TranslateScreen(selectedLang: String) {

    var inputText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        Text(
            text = "Translate",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Text", color = MaterialTheme.colorScheme.onBackground)
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                loading = true
                resultText = ""
                scope.launch(Dispatchers.IO) {        // ⬅ WAJIB pakai IO
                    try {
                        val r = TranslateRepository.translate(inputText, selectedLang)
                        resultText = r
                    } catch (e: Exception) {
                        resultText = "Error: ${e.message}"
                    } finally {
                        loading = false
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Translate")
        }


        Spacer(modifier = Modifier.height(12.dp))

        if (loading) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary
            )
        }

        if (!loading && resultText.isNotEmpty()) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = resultText,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
