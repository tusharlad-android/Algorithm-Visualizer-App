package com.tushar.algorithmvisualizer.RadixSort

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tushar.algorithmvisualizer.QuickSort.QuickSort
import com.tushar.algorithmvisualizer.algorithmEvents
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AlgorithmViewModel_Radix(private val radixSort: RadixSort): ViewModel() {
    var arr= mutableStateOf(intArrayOf(
        50,42,165,400,244,126,100,22,60,342,200,150,5
    ))
    val isPlaying= mutableStateOf(false);
    val onSortingFinish= mutableStateOf(false)
    private var delay=150L
    private var pause=false;
    private var next=1;
    private var previous=0;


    private var sortedArrayLevels = mutableListOf<List<Int>>()
    init{
        viewModelScope.launch {
            radixSort.sort(
                arr.value.clone()
            ){modifiedArray ->
                sortedArrayLevels.add(modifiedArray.toMutableList())

            }

        }
    }
    fun onEvent(event: algorithmEvents){
        when(event){
            is algorithmEvents.PlayPause ->{
                playPauseAlgorithm()
            }
            is algorithmEvents.slowDown ->{
                slowDownAlgorithm()
            }
            is algorithmEvents.SpeedUp ->{
                speedUpAlgorithm()
            }
            is algorithmEvents.Previous ->{
                previousAlgorithm()
            }
            is algorithmEvents.Next ->{
                nextAlgorithm()
            }
        }
    }

    private fun nextAlgorithm() {
        if(next<sortedArrayLevels.size){
            arr.value=sortedArrayLevels[next].toIntArray()
            next++
            previous++
        }

    }

    private fun previousAlgorithm() {
        if(previous>=0){
            arr.value=sortedArrayLevels[previous].toIntArray()
            next--
            previous--
        }
    }

    private fun speedUpAlgorithm() {
        delay+=100
    }

    private fun slowDownAlgorithm() {
        if(delay>=150L){
            delay-=50;
        }
    }

    private fun playPauseAlgorithm() {
        if(isPlaying.value){
            pause()
        }
        else{
            play()
            isPlaying.value=!isPlaying.value
        }

    }
    private var sortingstate=0;

    private fun play() =viewModelScope.launch{
        pause=false
        for(i in 0 until sortedArrayLevels.size){
            if(!pause){
                delay(delay)
                arr.value=sortedArrayLevels[i].toIntArray()


            }else{
                sortingstate=i;
                next=i+1
                previous=i

                return@launch
            }
        }
        onSortingFinish.value=true;
    }

    private fun pause() {
        pause=true;
    }


}