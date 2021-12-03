package com.example.colors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startGame = findViewById<Button>(R.id.startGame_btn)
        startGame.setOnClickListener{
            val intent = Intent(this,GameStartActivity::class.java)
            startActivity(intent)
        }
    }
}