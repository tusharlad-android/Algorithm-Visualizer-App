package com.tushar.algorithmvisualizer.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tushar.algorithmvisualizer.R

class profileFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=layoutInflater.inflate(R.layout.profile,container,false)
        return view
    }
}