package com.example.learning

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class WebActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_webview)

        val myWebView=findViewById<WebView>(R.id.Pe3)
        WebViewClient(myWebView)







    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun WebViewClient(webView: WebView) {
        webView.webViewClient = WebViewClient()
        webView.apply {
            webView.settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled=true
            loadUrl("https://tempo-deployment-61efead2-9f26-47fd-b6f5-4fd498a50cb-ar05cueem.vercel.app/")
        }

    }


}