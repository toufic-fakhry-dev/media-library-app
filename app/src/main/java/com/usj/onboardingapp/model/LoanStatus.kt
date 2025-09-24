package com.usj.onboardingapp.model

sealed class LoanStatus {
    object Available: LoanStatus()
    data class Loaned(val dueDate: String, val borrower: String): LoanStatus()
    object Returned: LoanStatus()
    object Overdue: LoanStatus()

    fun getLoanStatus(mediaItem: MediaItem): String {
        return when(mediaItem.loanStatus) {
            is Available -> "${mediaItem.title} is available for loan"
            is Loaned -> "${mediaItem.title} is loaned to ${(mediaItem.loanStatus as Loaned).borrower} by ${(mediaItem.loanStatus as Loaned).dueDate}"
            is Returned -> "${mediaItem.title} has been returned"
            is Overdue -> "${mediaItem.title} is overdue"
        }
    }
}