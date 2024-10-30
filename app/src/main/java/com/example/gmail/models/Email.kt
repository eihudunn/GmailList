package com.example.gmail.models

data class Email(
    val sender: String,
    val subject: String,
    val content: String,
    val time: String,
    val icon: Char,
    var isStarred: Boolean = false
)
