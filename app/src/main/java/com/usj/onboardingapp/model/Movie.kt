package com.usj.onboardingapp.model

class Movie(
    title: String,
    year: Int,
    loanStatus: LoanStatus,
    val genre: MovieGenre,
    val duration: Int,
    val director: String, isAvailable: Boolean,
    itemLogger: Logger
) : MediaItem(title, year, loanStatus, isAvailable, itemLogger)