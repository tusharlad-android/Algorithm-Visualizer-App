package com.tushar.algorithmvisualizer.MergeSort

import com.tushar.algorithmvisualizer.SelectionSort.AlgorithmViewModel_Selection
import com.tushar.algorithmvisualizer.SelectionSort.SelectionSort



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AlgorithmViewModelProvider_Merge(private val mergeSort: MergeSort) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlgorithmViewModel_Merge::class.java)) {
            return AlgorithmViewModel_Merge(mergeSort) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}