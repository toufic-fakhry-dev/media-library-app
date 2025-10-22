package com.usj.onboardingapp.interfaces

interface Playable {
    val duration: Int
    fun play()
    fun stop()
    fun pause(){
        println("Paused")
    }
}