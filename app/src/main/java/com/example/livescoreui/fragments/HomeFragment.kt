package com.example.livescoreui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.livescoreui.R


class HomeFragment : Fragment() {


    private lateinit var cardInflate: CardView
    private lateinit var containerLayout: FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewRoot : View =  inflater.inflate(R.layout.fragment_home, container, false)

        cardInflate = viewRoot.findViewById(R.id.barcaVSreal)
        containerLayout = viewRoot.findViewById(R.id.containerHomeLayout)

        cardInflate.setOnClickListener{
            val inflatedView = inflater.inflate(R.layout.details_match, containerLayout, false)
            containerLayout.addView(inflatedView)
        }

        return viewRoot
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {}
            }
    }

}