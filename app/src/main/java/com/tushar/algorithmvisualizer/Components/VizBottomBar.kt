package com.tushar.algorithmvisualizer.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.tushar.algorithmvisualizer.R


@Composable
fun VisBottomBar(
    modifier: Modifier=Modifier,
    playPauseClick: () -> Unit,
    slowDownCLick: () -> Unit,
    speedUpCLick: () -> Unit,
    previousClick: () -> Unit,
    nextCLick: () -> Unit,
    isPlaying: Boolean = false
) {
    BottomAppBar(
        modifier = modifier,

    ) {
        Row(
            modifier=modifier.fillMaxWidth(),
            verticalAlignment =Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly


        ){
            IconButton(
                onClick = slowDownCLick
            ){
                Icon(
                    painter= painterResource(R.drawable.horizontal),
                    contentDescription = "Slow down",
                    tint=MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                onClick = playPauseClick
            ){
                Icon(
                    painter= painterResource(
                        if (!isPlaying){
                            R.drawable.play
                        }
                        else {
                            R.drawable.pause
                        }
                    ),

                    contentDescription = "PlayPause",
                    tint=MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                onClick = speedUpCLick
            ){
                Icon(
                    painter= painterResource(R.drawable.speed),
                    contentDescription = "Speed Up",
                    tint=MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                onClick = previousClick
            ){
                Icon(
                    painter= painterResource(R.drawable.arrow_back),
                    contentDescription = "Previous",
                    tint=MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                onClick = nextCLick
            ){
                Icon(
                    painter= painterResource(R.drawable.arrow_forward),
                    contentDescription = "Next",
                    tint=MaterialTheme.colorScheme.onSurface
                )
            }

        }
    }
}
