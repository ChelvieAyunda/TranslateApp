import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

object TranslateApi {

    suspend fun translate(
        text: String,
        target: String,
        source: String = "auto"
    ): String {

        return kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            val url = URL("https://translate.fedilab.app/translate")


            val postData =
                "q=${java.net.URLEncoder.encode(text, "UTF-8")}&source=$source&target=$target&format=text"

            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"
            conn.doOutput = true
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")

            conn.outputStream.use { it.write(postData.toByteArray()) }

            val response = conn.inputStream.bufferedReader().use { it.readText() }

            val json = JSONObject(response)
            json.getString("translatedText")
        }
    }
}
