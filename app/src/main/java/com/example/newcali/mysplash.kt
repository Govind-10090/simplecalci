package com.example.newcali

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class mysplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mysplash)

        GlobalScope.launch {
            delay(3000)
            val intent = Intent(this@mysplash, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}