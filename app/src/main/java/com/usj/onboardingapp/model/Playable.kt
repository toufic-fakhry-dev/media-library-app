package com.usj.onboardingapp.model

interface Playable {
    val duration: Int
    fun play()
    fun stop()
    fun pause(){
        println("Paused")
    }
}