package com.tushar.algorithmvisualizer.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.tushar.algorithmvisualizer.R

class List_Activity:AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)
        imageView=findViewById(R.id.img_listactivity)
        textView=findViewById(R.id.txt_list)

        val value=intent.getStringExtra("value")
        when(value){
            "insertion"->{
                imageView.setImageResource(R.drawable.insertion)
                textView.setText("Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part." +
                        "To sort an array of size N in ascending order iterate over the array and compare the current element (key) to its predecessor, if the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.\n"
                        )
            }
            "selection"->{
                imageView.setImageResource(R.drawable.selection)
                textView.setText("Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting the smallest (or largest) element from the unsorted portion of the list and moving it to the sorted portion of the list. " +
                        "The algorithm repeatedly selects the smallest (or largest) element from the unsorted portion of the list and swaps it with the first element of the unsorted part. This process is repeated for the remaining unsorted portion until the entire list is sorted. ")

            }

        }
    }
}