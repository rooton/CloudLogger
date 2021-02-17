package com.cloudyapi.cloudlogger

object CloudLogger {

    const val TAG = "CLOUD-LOGGER"
    private const val API_URL = "https://logger.cloudyapi.com/api/v1/log"

    private var cloudLogger: AndroidCloudLogger? = null

    fun initialize(key: String) {
        println("$TAG: CloudLogger Initialized")

        val url = "$API_URL/$key"

        cloudLogger = DefaultAndroidCloudLogger(
            url
        )
    }

    fun sendLog(log: String) {
        send(log)
    }

    private fun send(log: String) {
        cloudLogger?.sendLog(log)
            ?: println("$TAG: CloudLogger not initialized!")
    }
}
