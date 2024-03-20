package com.abqamar.mylocaleapplication

import android.app.LocaleManager
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.abqamar.mylocaleapplication.ui.theme.MyLocaleApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLocaleApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth(),
    ){
        Text(text = "${context.getString(R.string.welcome)}, Abdul Basit")
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp), Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.Black.copy(alpha = 0.8f)), Alignment.BottomCenter
            ){
                Row(
                    modifier = Modifier.align(alignment = Alignment.Center)
                ){
                    Text(
                        "English", color = Color.White, fontSize = 16.sp,
                        modifier = Modifier
                            .clickable {
                                Log.d("SplashScreen", "Detect Click English")
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                    context.getSystemService(LocaleManager::class.java)
                                        .applicationLocales = LocaleList.forLanguageTags("en")
                                } else {
                                    AppCompatDelegate.setApplicationLocales(
                                        LocaleListCompat.forLanguageTags(
                                            "en"
                                        )
                                    )
                                }
                            }
                            .weight(1f), textAlign = TextAlign.Center
                    )
                    Text(
                        "العربية", color = Color.White, fontSize = 16.sp,
                        modifier = Modifier
                            .clickable {
                                Log.d("SplashScreen", "Detect Click Arabic")
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                    context.getSystemService(LocaleManager::class.java)
                                        .applicationLocales = LocaleList.forLanguageTags("ar")
                                } else {
                                    AppCompatDelegate.setApplicationLocales(
                                        LocaleListCompat.forLanguageTags(
                                            "ar"
                                        )
                                    )
                                }

                            }
                            .weight(1f), textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLocaleApplicationTheme {
        Greeting()
    }
}