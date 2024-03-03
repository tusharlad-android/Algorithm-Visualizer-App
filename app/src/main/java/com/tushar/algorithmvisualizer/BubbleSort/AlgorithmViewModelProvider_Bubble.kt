package com.tushar.algorithmvisualizer.BubbleSort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tushar.algorithmvisualizer.Insertionsort.AlgorithmViewModel
import com.tushar.algorithmvisualizer.Insertionsort.InsertionSort

class AlgorithmViewModelProvider_Bubble(private val bubbleSort: BubbleSort) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlgorithmViewModel_Bubble::class.java)) {
            return AlgorithmViewModel_Bubble(bubbleSort) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}