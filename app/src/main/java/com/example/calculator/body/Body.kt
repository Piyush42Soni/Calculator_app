package com.example.calculator.body

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.R
import com.example.calculator.databinding.FragmentBodyBinding

class Body : Fragment() {
    private val KEY="yoho"
    lateinit var word:String
    private lateinit var h:ConstraintLayout
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<FragmentBodyBinding>(inflater,
            R.layout.fragment_body, container, false)
        val viewModel: BodyViewModel = ViewModelProvider(this).get(BodyViewModel::class.java)
        binding.viewModel=viewModel
        viewModel.word.observe(this, Observer { newScore ->
            binding.text.text = newScore.toString()
        })
        return binding.root
    }

}