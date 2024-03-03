package com.tushar.algorithmvisualizer.BubbleSort

class BubbleSort {
    suspend fun sort(
        arr: IntArray,
        onSwap: (IntArray) -> Unit
    ) {
        val n = arr.size
        var swapped: Boolean

        for (i in 0 until n - 1) {
            swapped = false
            for (j in 0 until n - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                    onSwap(arr)
                    swapped = true
                }
            }

            // If no two elements were swapped in inner loop, the array is already sorted
            if (!swapped) {
                break
            }
        }
    }
}
