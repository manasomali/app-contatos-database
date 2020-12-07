package com.example.exerciciodatabase.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exerciciodatabase.R
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_main)
        activityScope.launch {
            delay(1500)

            var intent = Intent(this@SplashActivity, ListaContatosActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }
}