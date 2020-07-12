package com.example.myapplication.home

sealed class HomeActivityItemViewModelType

data class HomeActivityItemViewModel(val id: String) : HomeActivityItemViewModelType() {
    companion object {
        fun create(id: Int): HomeActivityItemViewModel = HomeActivityItemViewModel(id.toString())
    }
}