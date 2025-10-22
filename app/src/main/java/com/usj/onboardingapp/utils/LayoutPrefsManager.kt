package com.usj.onboardingapp.utils

import android.content.Context
import androidx.core.content.edit

object LayoutPrefsManager {
    val PREFS_NAME: String = "layout_style"
    val LAYOUT_GRID: String = "grid"
    val LAYOUT_LIST: String = "list"

    fun getLayoutStyle(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(
            PREFS_NAME, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(PREFS_NAME, LAYOUT_LIST) ?: LAYOUT_LIST
    }

    fun setLayoutStyle(context: Context, layoutStyle: String) {
        val sharedPreferences = context.getSharedPreferences(
            PREFS_NAME, Context.MODE_PRIVATE
        )
        sharedPreferences.edit {
            putString(PREFS_NAME, layoutStyle)
        }
    }

}