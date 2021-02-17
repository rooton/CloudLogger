package com.cloudyapi.cloudloggerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.cloudyapi.cloudlogger.CloudLogger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickMe = findViewById<Button>(R.id.clickMe)

        clickMe.setOnClickListener {
            repeat(1000) {
                CloudLogger.sendLog("Test Object")
            }
        }
    }
}