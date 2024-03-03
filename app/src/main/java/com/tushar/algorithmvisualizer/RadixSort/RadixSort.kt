package com.tushar.algorithmvisualizer.RadixSort

import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow



class RadixSort {
    suspend fun sort(arr: IntArray, onPass: (IntArray) -> Unit) {
        val maxDigitCount = getMaxDigitCount(arr)

        for (digitPlace in 0 until maxDigitCount) {
            val countArray = IntArray(10) // 10 possible digits (0-9)
            val tempArray = IntArray(arr.size)

            for (num in arr) {
                val digit = getDigit(num, digitPlace)
                countArray[digit]++
            }

            for (i in 1 until 10) {
                countArray[i] += countArray[i - 1]
            }

            for (i in arr.size - 1 downTo 0) {
                val digit = getDigit(arr[i], digitPlace)
                tempArray[countArray[digit] - 1] = arr[i]
                countArray[digit]--
            }

            System.arraycopy(tempArray, 0, arr, 0, arr.size)
            onPass(arr)
        }
    }

    private fun getMaxDigitCount(arr: IntArray): Int {
        var maxDigitCount = 0
        for (num in arr) {
            val currentDigitCount = getDigitCount(num)
            if (currentDigitCount > maxDigitCount) {
                maxDigitCount = currentDigitCount
            }
        }
        return maxDigitCount
    }

    private fun getDigit(num: Int, place: Int): Int {
        return (num / 10.0.pow(place.toDouble()).toInt()) % 10
    }

    private fun getDigitCount(num: Int): Int {
        if (num == 0) {
            return 1
        }
        return (log10(abs(num.toDouble())) + 1).toInt()
    }
}
