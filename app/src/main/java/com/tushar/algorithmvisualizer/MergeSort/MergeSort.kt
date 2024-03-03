package com.tushar.algorithmvisualizer.MergeSort



class MergeSort {
    suspend fun sort(arr: IntArray, onMerge: (IntArray) -> Unit) {
        if (arr.size <= 1) {
            return
        }

        val mid = arr.size / 2
        val left = arr.copyOfRange(0, mid)
        val right = arr.copyOfRange(mid, arr.size)

        sort(left, onMerge)
        sort(right, onMerge)

        var i = 0
        var j = 0
        var k = 0

        while (i < left.size && j < right.size) {
            if (left[i] < right[j]) {
                arr[k] = left[i]
                i++
            } else {
                arr[k] = right[j]
                j++
            }
            k++
            onMerge(arr)
        }

        while (i < left.size) {
            arr[k] = left[i]
            i++
            k++
            onMerge(arr)
        }

        while (j < right.size) {
            arr[k] = right[j]
            j++
            k++
            onMerge(arr)
        }
    }
}
