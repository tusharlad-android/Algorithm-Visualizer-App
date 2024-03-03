package com.tushar.algorithmvisualizer.SelectionSort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AlgorithmViewModelProvider_Selection(private val selectionSort: SelectionSort) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlgorithmViewModel_Selection::class.java)) {
            return AlgorithmViewModel_Selection(selectionSort) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}