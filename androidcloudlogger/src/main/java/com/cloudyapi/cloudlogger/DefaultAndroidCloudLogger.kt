package com.cloudyapi.cloudlogger

import com.cloudyapi.cloudlogger.CloudLogger.TAG
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

private const val LOG_FIELD = "log"

class DefaultAndroidCloudLogger(
    private val url: String
) : AndroidCloudLogger {

    private val okHttpClient by lazy {
        OkHttpClient()
    }

    override  fun sendLog(log: String) {

        println("$TAG: CloudLogger send log")

        val formBody = FormBody.Builder()
            .add(LOG_FIELD, log)
            .build()

        val request = Request.Builder()
            .url(url)
            .post(formBody)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                println("$TAG: Android onFailure: $e")
            }

            override fun onResponse(call: Call, response: Response) {
                println("$TAG: Android onResponse: ${response.body}")
            }
        })
    }
}
