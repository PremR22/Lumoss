package com.example.lumos.viewmodel

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    fun login(username: String, password: String) {
        // Handle login logic (API calls, validation, etc.)
        if (username == "admin" && password == "password") {
            println("Login Successful")
        } else {
            println("Login Failed")
        }
    }
}
