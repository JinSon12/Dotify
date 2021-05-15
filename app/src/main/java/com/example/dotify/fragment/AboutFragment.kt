package com.example.dotify.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dotify.BuildConfig
import com.example.dotify.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private val navController by lazy { findNavController() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val binding = FragmentAboutBinding.inflate(inflater)



        with(binding) {
            val versionName = BuildConfig.VERSION_NAME
            tvVersion.text = "Version : $versionName"
        }

        return binding.root
    }

}