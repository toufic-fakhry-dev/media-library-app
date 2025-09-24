package com.usj.onboardingapp.model

class AudioBook(
    title: String,
    year: Int,
    author: String,
    loanStatus: LoanStatus,
    pages: Int = 0,
    val narrator: String,
    override val duration: Int,
    isAvailable: Boolean
) :
    Book(title, year, author, loanStatus, pages, isAvailable), Playable {

    override fun play() {
        println("Playing $title")
    }

    override fun stop() {
        println("Stopping $title")
    }
}