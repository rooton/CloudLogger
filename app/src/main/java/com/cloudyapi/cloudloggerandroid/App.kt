package com.cloudyapi.cloudloggerandroid

import android.app.Application
import com.cloudyapi.cloudlogger.CloudLogger

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        CloudLogger.initialize(
            key = "6006f52a0fef5f8e56625d65"
        )

        //Fresco.initialize(this)
        println("MEGA-BUBU => App Created")
    }
}