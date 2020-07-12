package com.example.myappdata.transaction.entity

import com.example.myapptransaction.model.DetailComment
import com.google.gson.annotations.SerializedName

class DetailCommentEntity(
    @SerializedName("by") val by: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("time") val time: Long? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("kids") val kids: List<Int>? = null
) {
    fun create(): DetailComment {
        return DetailComment(
            by = by.orEmpty(),
            title = title.orEmpty(),
            url = url.orEmpty(),
            id = id ?: 0,
            time = time ?: 0,
            kids = kids ?: listOf()
        )
    }
}