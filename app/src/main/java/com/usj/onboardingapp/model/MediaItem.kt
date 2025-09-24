package com.usj.onboardingapp.model

open class MediaItem(val title: String, val year: Int, var loanStatus: LoanStatus, isAvailable: Boolean) {
    companion object{
        val MAX_TITLE_LENGTH = 100
        fun createPlaceholderItem(): MediaItem{
            return MediaItem("Placeholder", 0, LoanStatus.Available, false)
        }
    }
    init {
        require(title.isNotBlank())
        require(year in 1900..2023)
        println("New media item created $title")
    }
}