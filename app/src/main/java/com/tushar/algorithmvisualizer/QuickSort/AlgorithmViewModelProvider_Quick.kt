package com.tushar.algorithmvisualizer.QuickSort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tushar.algorithmvisualizer.SelectionSort.AlgorithmViewModel_Selection
import com.tushar.algorithmvisualizer.SelectionSort.SelectionSort

class AlgorithmViewModelProvider_Quick(private val quickSort: QuickSort) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlgorithmViewModel_Quick::class.java)) {
            return AlgorithmViewModel_Quick(quickSort) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}