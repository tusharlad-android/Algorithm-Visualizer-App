package com.tushar.algorithmvisualizer.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tushar.algorithmvisualizer.question.MCQ_Activity
import com.tushar.algorithmvisualizer.R

class mcqFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.mcq, container, false)
        val intent=Intent(context, MCQ_Activity::class.java)
        startActivity(intent)
        return view
    }
}
