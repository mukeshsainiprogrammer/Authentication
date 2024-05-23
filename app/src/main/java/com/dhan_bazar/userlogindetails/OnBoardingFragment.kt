package com.dhan_bazar.softwarelab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.dhan_bazar.userlogindetails.FirstFragment
import com.dhan_bazar.userlogindetails.R
import com.dhan_bazar.userlogindetails.SecondFragment
import com.dhan_bazar.userlogindetails.ThirdFragment
import com.dhan_bazar.userlogindetails.ViewPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator // Ensure you have this dependency

class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter
        val indicator = view.findViewById<DotsIndicator>(R.id.dots_indicator)
        indicator.setViewPager2(viewPager)

        return view
    }
}
