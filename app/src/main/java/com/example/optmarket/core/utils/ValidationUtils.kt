package com.example.optmarket.core.utils

object ValidationUtils {
    fun isValidPassword(password: String): Boolean {
        val regex = Regex("^[a-zA-Z0-9]{8,}$")
        return regex.matches(password)
    }

    fun isValidEmail(email: String): Boolean {
        val regex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        return regex.matches(email)
    }
}