package com.tushar.algorithmvisualizer.MergeSort

import com.tushar.algorithmvisualizer.SelectionSort.AlgorithmViewModelProvider_Selection
import com.tushar.algorithmvisualizer.SelectionSort.AlgorithmViewModel_Selection
import com.tushar.algorithmvisualizer.SelectionSort.SelectionSort



import android.os.Bundle
import androidx.activity.compose.setContent

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider

import com.tushar.algorithmvisualizer.Components.VisBottomBar
import com.tushar.algorithmvisualizer.Components.VisualizerSection

import com.tushar.algorithmvisualizer.algorithmEvents
import com.tushar.algorithmvisualizer.ui.theme.AlgorithmVisualizerTheme
class Merge_Activity : AppCompatActivity() {
    private val viewModel: AlgorithmViewModel_Merge by lazy {
        val viewModelProviderFactory= AlgorithmViewModelProvider_Merge(MergeSort())
        ViewModelProvider(this,viewModelProviderFactory)[AlgorithmViewModel_Merge::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgorithmVisualizerTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    contentAlignment= Alignment.BottomCenter
                )
                {
                    Column {
                        VisualizerSection(
                            arr =viewModel.arr.value,
                            modifier = Modifier.fillMaxWidth()
                        )
                        val isPlaying=viewModel.isPlaying.value
                        val isFinished=viewModel.onSortingFinish.value
                        VisBottomBar(

                            playPauseClick = { viewModel.onEvent(algorithmEvents.PlayPause) },
                            slowDownCLick = { viewModel.onEvent(algorithmEvents.slowDown) },
                            speedUpCLick = { viewModel.onEvent(algorithmEvents.SpeedUp) },
                            previousClick = { viewModel.onEvent(algorithmEvents.Previous) },
                            nextCLick = { viewModel.onEvent(algorithmEvents.Next)},
                            modifier = Modifier.fillMaxWidth()
                                .height(75.dp),
                            isPlaying = if(isFinished) !isFinished else isPlaying


                        )

                    }
                }

            }
        }
    }
}