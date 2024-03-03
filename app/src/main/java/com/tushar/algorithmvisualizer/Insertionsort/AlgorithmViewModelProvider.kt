package com.tushar.algorithmvisualizer.Insertionsort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AlgorithmViewModelProvider(private val insertionSort: InsertionSort) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlgorithmViewModel::class.java)) {
            return AlgorithmViewModel(insertionSort) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
