// data/repository/TranslateRepository.kt
package com.chelvie.translateapp.ui.theme.screens

object TranslateRepository {

    // jadikan suspend
    suspend fun translate(text: String, target: String): String {
        return TranslateApi.translate(text, target)
    }
}
