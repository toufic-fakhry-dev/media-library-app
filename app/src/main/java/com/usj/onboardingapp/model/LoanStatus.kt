package com.usj.onboardingapp.model

sealed class LoanStatus {
    object Available: LoanStatus()
    data class Loaned(val dueDate: String, val borrower: String): LoanStatus()
    object Returned: LoanStatus()
    object Overdue: LoanStatus()

    fun getLoanStatus(mediaItem: MediaItem): String {
        val currentStatus = mediaItem.loanStatus
        return when(currentStatus) {
            is Available -> "${mediaItem.title} is available for loan"
            is Loaned -> "${mediaItem.title} is loaned to ${currentStatus.borrower} by ${currentStatus.dueDate}"
            is Returned -> "${mediaItem.title} has been returned"
            is Overdue -> "${mediaItem.title} is overdue"
        }
    }
}