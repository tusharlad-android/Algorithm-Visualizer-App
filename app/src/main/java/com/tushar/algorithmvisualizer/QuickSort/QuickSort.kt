package com.tushar.algorithmvisualizer.QuickSort



class QuickSort {
    suspend fun sort(arr: IntArray, onSwap: (IntArray) -> Unit) {
        quickSort(arr, 0, arr.size - 1, onSwap)
    }

    private suspend fun quickSort(arr: IntArray, low: Int, high: Int, onSwap: (IntArray) -> Unit) {
        if (low < high) {
            val pivotIndex = partition(arr, low, high, onSwap)
            quickSort(arr, low, pivotIndex - 1, onSwap)
            quickSort(arr, pivotIndex + 1, high, onSwap)
        }
    }

    private suspend fun partition(arr: IntArray, low: Int, high: Int, onSwap: (IntArray) -> Unit): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
                onSwap(arr)
            }
        }
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        onSwap(arr)
        return i + 1
    }
}
