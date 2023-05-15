package com.example.livescoreui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.livescoreui.R


class DiscoveryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discovery, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            DiscoveryFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}