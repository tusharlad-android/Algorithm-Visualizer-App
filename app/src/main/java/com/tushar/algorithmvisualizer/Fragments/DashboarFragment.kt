package com.tushar.algorithmvisualizer.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.tushar.algorithmvisualizer.Activity.List_Activity
import com.tushar.algorithmvisualizer.BubbleSort.Bubble_Activity
import com.tushar.algorithmvisualizer.Insertionsort.Insertion_Activity
import com.tushar.algorithmvisualizer.MergeSort.Merge_Activity
import com.tushar.algorithmvisualizer.QuickSort.Quick_Activity
import com.tushar.algorithmvisualizer.SelectionSort.Selection_Activity

import com.tushar.algorithmvisualizer.R
import com.tushar.algorithmvisualizer.RadixSort.Radix_Activity

class DashboarFragment:Fragment() {
    lateinit var insertion_play: ImageView
    lateinit var selection_play:ImageView
    lateinit var merge_play:ImageView
    lateinit var quick_play:ImageView
    lateinit var bubble_play:ImageView
    lateinit var radix_play:ImageView
    lateinit var binary_play:ImageView
    lateinit var counting_play:ImageView
    lateinit var linear_play:ImageView
    lateinit var breadth_play:ImageView
    lateinit var insertion_list:ImageView
    lateinit var selection_list:ImageView
    lateinit var merge_list:ImageView
    lateinit var quick_list:ImageView
    lateinit var bubble_list:ImageView
    lateinit var radix_list:ImageView
    lateinit var binary_list:ImageView
    lateinit var counting_list:ImageView
    lateinit var linear_list:ImageView
    lateinit var breadth_list:ImageView
    lateinit var imageView_List: ImageView
    lateinit var textView_List:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dashboard, container, false)
        setHasOptionsMenu(true)
        insertion_play=view.findViewById(R.id.play_insertion)
        selection_play=view.findViewById(R.id.play_selection)
        merge_play=view.findViewById(R.id.play_merge)
        quick_play=view.findViewById(R.id.play_quick)
        bubble_play=view.findViewById(R.id.play_bubble)
        radix_play=view.findViewById(R.id.play_radix)
        binary_play=view.findViewById(R.id.play_binary)
        counting_play=view.findViewById(R.id.play_counting)
        linear_play=view.findViewById(R.id.play_linear)
        breadth_play=view.findViewById(R.id.play_breadth)
        insertion_list=view.findViewById(R.id.list_insertion)
        selection_list=view.findViewById(R.id.list_selection)
        merge_list=view.findViewById(R.id.list_merge)
        quick_list=view.findViewById(R.id.list_quick)
        bubble_list=view.findViewById(R.id.list_bubble)
        radix_list=view.findViewById(R.id.list_radix)
        binary_list=view.findViewById(R.id.list_binary)
        counting_list=view.findViewById(R.id.list_counting)
        linear_list=view.findViewById(R.id.list_linear)
        breadth_list=view.findViewById(R.id.list_breadth)




        //onclick listener
        insertion_play.setOnClickListener {
            val intent=Intent(context, Insertion_Activity::class.java)
            startActivity(intent)


        }
        selection_play.setOnClickListener {
            val intent=Intent(context, Selection_Activity::class.java)
            startActivity(intent)
        }
        merge_play.setOnClickListener {
            val intent=Intent(context,Merge_Activity::class.java)
            startActivity(intent)
        }
        quick_play.setOnClickListener {
            val intent=Intent(context,Quick_Activity::class.java)
            startActivity(intent)
        }
        bubble_play.setOnClickListener {
            val intent=Intent(context,Bubble_Activity::class.java)
            startActivity(intent)
        }
        radix_play.setOnClickListener {
            val intent=Intent(context,Radix_Activity::class.java)
            startActivity(intent)
        }
        insertion_list.setOnClickListener {
            val intent=Intent(context, List_Activity::class.java)
            intent.putExtra("value","insertion")
            startActivity(intent)
        }
        selection_list.setOnClickListener {
            val intent=Intent(context, List_Activity::class.java)
            intent.putExtra("value","selection")
            startActivity(intent)
        }













        return view
    }
}