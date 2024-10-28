package com.example.datingapp.models

data class User(
    var id: String = "",
    val email: String = "",
    val nickname: String = "",
    val introduction: String = "",
    val gender: Gender = Gender.MALE,
    val age: Int = 0,
    val image: String = ""
)

enum class Gender {
    MALE,
    FEMALE
}