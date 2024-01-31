package com.example.browsercloneapp

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.browsercloneapp.databinding.ActivityMainBinding
import com.example.browsercloneapp.databinding.ActivityMainWebBinding
import com.example.browsercloneapp.utils.obj

class MainActivity : AppCompatActivity()
{
    //binding
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initViews
        binding.apply {
            setupDarkMode()

            ivMic.setOnClickListener{
                obj.searchText1 = etSearch.text.toString()
                val intent = Intent(this@MainActivity,MainWebActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.etSearch.text.clear()
    }
    private fun setupDarkMode(){
        when(resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK)
        {
            Configuration.UI_MODE_NIGHT_NO ->{
                //Night mode is not active
                setupGoogleLogo()
            }
            Configuration.UI_MODE_NIGHT_YES ->{
                //Night Mode is active
                binding.tvGoogle.setTextColor(Color.WHITE)
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED ->{
                //we don't know what mode we're in , assume light
                setupGoogleLogo()
            }
        }
    }
    private fun setupGoogleLogo(){
        binding.tvGoogle.apply {
            val spannable = SpannableString("Google")
            //Blue
            spannable.setSpan(
                ForegroundColorSpan(Color.parseColor("#398af6")),
                0,
                1,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            //Red
            spannable.setSpan(
                ForegroundColorSpan(Color.parseColor("#e94635")),
                1,
                2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            //orange
            spannable.setSpan(
                ForegroundColorSpan(Color.parseColor("#feb906")),
                2,
                3,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            //blue
            spannable.setSpan(
                ForegroundColorSpan(Color.parseColor("#3f87f3")),
                3,
                4,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            //Green
            spannable.setSpan(
                ForegroundColorSpan(Color.parseColor("#36a74b")),
                4,
                5,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            //Red
            spannable.setSpan(
                ForegroundColorSpan(Color.parseColor("#ed4039")),
                5,
                6,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            text = spannable
        }
    }
}