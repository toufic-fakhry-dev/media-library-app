package com.usj.onboardingapp.model

class Movie(
    title: String,
    year: Int,
    loanStatus: LoanStatus,
    val genre: MovieGenre,
    val duration: Int,
    val director: String, isAvailable: Boolean
) : MediaItem(title, year, loanStatus, isAvailable)