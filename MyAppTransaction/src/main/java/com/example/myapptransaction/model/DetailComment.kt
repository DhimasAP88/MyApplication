package com.example.myapptransaction.model

data class DetailComment(
    val by: String,
    val time: Long,
    val title: String,
    val url: String,
    val id: Int,
    val kids: List<Int>
)