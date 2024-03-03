package com.tushar.algorithmvisualizer

sealed class algorithmEvents{
    object slowDown: algorithmEvents()
    object PlayPause: algorithmEvents()
    object SpeedUp: algorithmEvents()
    object Previous: algorithmEvents()
    object Next: algorithmEvents()
}