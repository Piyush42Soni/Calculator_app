package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.calculator.databinding.FragmentBodyBinding
import com.example.calculator.databinding.FragmentIntroBinding

class Intro : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentIntroBinding>(
            inflater,
            R.layout.fragment_intro,
            container,
            false
        )
        binding.nextButton.setOnClickListener { view: View ->
            view.findNavController().navigate(IntroDirections.actionIntroToBody())
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}
