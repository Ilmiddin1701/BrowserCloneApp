package com.example.browsercloneapp

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.browsercloneapp.databinding.ActivityMainWebBinding
import com.example.browsercloneapp.utils.obj

class MainWebActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainWebBinding.inflate(layoutInflater) }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.myWebView.loadUrl("https://www.google.com/search?q=${obj.searchText1}&sourceid=chrome&ie=UTF-8")
        binding.myWebView.settings.javaScriptEnabled = true
        binding.myWebView.settings.safeBrowsingEnabled = true

        binding.ivSearch.setOnClickListener {
            obj.searchText1 = binding.edtSearch.text.toString()
            binding.myWebView.loadUrl("https://www.google.com/search?q=${obj.searchText1}&sourceid=chrome&ie=UTF-8")

            binding.myWebView.webViewClient = object : WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressBar.visibility = View.GONE
                }
            }
        }

        binding.myWebView.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    override fun onBackPressed() {
        if (binding.myWebView.canGoBack()) binding.myWebView.goBack() else super.onBackPressed()
    }
}