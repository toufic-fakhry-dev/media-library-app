package com.usj.onboardingapp.model

open class Book(
    title: String,
    year: Int,
    val author: String,
    loanStatus: LoanStatus,
    val pages: Int,
    isAvailable: Boolean,
    itemLogger: Logger,
    val genre: BookGenre
) : MediaItem(title, year, loanStatus, isAvailable, itemLogger)