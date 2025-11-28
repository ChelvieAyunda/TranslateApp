package com.chelvie.translateapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.chelvie.translateapp.ui.theme.screens.TranslateRepository
import kotlinx.coroutines.Dispatchers

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

class TranslateViewModel : ViewModel() {

    var input by mutableStateOf("")
    var result by mutableStateOf("")
    var loading by mutableStateOf(false)

    fun translate(target: String) {
        loading = true

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val r = TranslateRepository.translate(input, target)
                result = r
            } catch (e: Exception) {
                result = "Error: ${e.message}"
            } finally {
                loading = false
            }
        }
    }
}
