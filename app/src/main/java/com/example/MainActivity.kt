package com.example

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ui.theme.NavyBackground

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      Surface(
        modifier = Modifier
          .fillMaxSize()
          .background(NavyBackground)
          .statusBarsPadding()
          .navigationBarsPadding(),
        color = Color(0xFF090D1A)
      ) {
        MindOSWebApp()
      }
    }
  }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun MindOSWebApp() {
  var webViewRef: WebView? = remember { null }

  BackHandler(enabled = true) {
    if (webViewRef?.canGoBack() == true) {
      webViewRef?.goBack()
    }
  }

  AndroidView(
    factory = { context ->
      WebView(context).apply {
        webViewRef = this
        settings.apply {
          javaScriptEnabled = true
          domStorageEnabled = true
          databaseEnabled = true
          allowFileAccess = true
          allowContentAccess = true
          useWideViewPort = true
          loadWithOverviewMode = true
          cacheMode = WebSettings.LOAD_NO_CACHE
        }
        webViewClient = WebViewClient()
        webChromeClient = WebChromeClient()
        setBackgroundColor(android.graphics.Color.parseColor("#090D1A"))
        loadUrl("file:///android_asset/web/index.html")
      }
    },
    modifier = Modifier.fillMaxSize()
  )
}
