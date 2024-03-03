package com.tushar.algorithmvisualizer.RadixSort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tushar.algorithmvisualizer.QuickSort.AlgorithmViewModel_Quick
import com.tushar.algorithmvisualizer.QuickSort.QuickSort

class AlgorithmViewModelProvider_Radix(private val radixSort: RadixSort) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlgorithmViewModel_Radix::class.java)) {
            return AlgorithmViewModel_Radix(radixSort) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}