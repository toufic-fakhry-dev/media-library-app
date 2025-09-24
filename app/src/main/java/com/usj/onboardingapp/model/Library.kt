package com.usj.onboardingapp.model

typealias LibraryCollection = MutableList<MediaItem>

class Library {
    val allItems: LibraryCollection by lazy {
        println("Initializing library items...")
        mutableListOf(
            Book(
                "The Great Gatsby",
                1925,
                "F. Scott Fitzgerarld",
                LoanStatus.Available,
                180,
                true
            ),
            Movie(
                "The Shawshank Redemption",
                1994,
                LoanStatus.Available,
                MovieGenre.DRAMA,
                190,
                "Frank Darabont",
                true
            )
        )
    }

    fun addItem(item: MediaItem){
        allItems.add(item)
    }
}