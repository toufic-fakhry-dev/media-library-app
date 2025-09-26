package com.usj.onboardingapp.model

open class MediaItem(
    val title: String,
    val year: Int,
    var loanStatus: LoanStatus,
    isAvailable: Boolean,
    private val itemLogger: Logger
) : Logger by itemLogger {
    companion object {
        val MAX_TITLE_LENGTH = 100
        fun createPlaceholderItem(): MediaItem {
            return MediaItem("Placeholder", 0, LoanStatus.Available,false, ConsoleLogger())
        }
    }

    init {
        require(title.isNotBlank())
        require(year in 1900..2023)
        println("New media item created $title")
    }

    fun borrowItem(borrower: String) {
        if (loanStatus is LoanStatus.Available) {
            loanStatus = LoanStatus.Loaned("SomeDueDate", borrower)
            // Use the delegated logInfo method
            logInfo("Item '$title' borrowed by $borrower.")
        } else {
            // Use the delegated logError method
            logError("Failed to borrow '$title': Item not available. Status: $loanStatus")
        }
    }

    fun returnItem() {
        if (loanStatus is LoanStatus.Loaned) {
            val previousBorrower = (loanStatus as LoanStatus.Loaned).borrower
            loanStatus = LoanStatus.Available
            logInfo("Item '$title' returned by $previousBorrower.")
        } else {
            logError("Failed to return '$title': Item was not on loan. Status: $loanStatus")
        }
    }
}