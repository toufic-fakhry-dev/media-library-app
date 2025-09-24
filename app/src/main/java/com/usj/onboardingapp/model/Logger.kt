package com.usj.onboardingapp.model

interface Logger {
    fun logInfo(message: String)
    fun logError(message: String, exception: Throwable? = null)
    fun logDebug(message: String) // Maybe only logs in debug builds
}

// Logs to the console
class ConsoleLogger(private val tag: String = "App") : Logger {
    override fun logInfo(message: String) {
        println("INFO [$tag]: $message")
    }

    override fun logError(message: String, exception: Throwable?) {
        System.err.println("ERROR [$tag]: $message")
        exception?.printStackTrace(System.err)
    }

    override fun logDebug(message: String) {
        // In a real app, you might check a BuildConfig.DEBUG flag
        println("DEBUG [$tag]: $message")
    }
}

// Logs to a (simulated) file - in a real app, this would write to an actual file
class FileLogger(private val filePath: String) : Logger {
    private val logEntries = mutableListOf<String>() // Simulate file content

    override fun logInfo(message: String) {
        val entry = "INFO: $message"
        logEntries.add(entry)
        // In a real app: appendToFile(filePath, entry)
        println("FileLog -> $entry (to $filePath)")
    }

    override fun logError(message: String, exception: Throwable?) {
        val entry = "ERROR: $message ${exception?.message ?: ""}"
        logEntries.add(entry)
        // In a real app: appendToFile(filePath, entry)
        println("FileLog -> $entry (to $filePath)")
    }

    override fun logDebug(message: String) {
        // Potentially do nothing for file logger in release, or write to a separate debug file
        val entry = "DEBUG: $message"
        logEntries.add(entry)
        println("FileLog -> $entry (to $filePath)")
    }

    fun getLogs(): List<String> = logEntries
}

// A logger that does nothing (useful for release builds or specific contexts)
object NoOpLogger : Logger {
    override fun logInfo(message: String) {}
    override fun logError(message: String, exception: Throwable?) {}
    override fun logDebug(message: String) {}
}