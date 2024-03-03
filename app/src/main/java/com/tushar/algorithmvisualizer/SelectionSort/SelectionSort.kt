package com.tushar.algorithmvisualizer.SelectionSort



class SelectionSort {
    suspend fun sort(
        arr: IntArray,
        onSwap: (IntArray) -> Unit
    ) {
        val n = arr.size
        for (i in 0 until n - 1) {
            var minIndex = i
            for (j in i + 1 until n) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != i) {
                val temp = arr[i]
                arr[i] = arr[minIndex]
                arr[minIndex] = temp
                onSwap(arr)
            }
        }
    }
}
