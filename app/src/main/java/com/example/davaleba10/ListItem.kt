package com.example.davaleba10

data class ListItem(
    val startIcon: Int,
    val text: String,
    val secondIcon: Int? = null,
    val fieldType: FieldType,
    val extraText: String? = null
)

enum class FieldType {
    NORMAL,
    LANGUAGE,
    DARK_MODE,
    LOGOUT
}

