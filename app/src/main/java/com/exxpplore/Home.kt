package com.exxpplore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout

class Home : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout2)
        tabLayout.addTab(
            tabLayout.newTab().setText("Tab")
        )

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
        Home().apply {

        }
    }
}