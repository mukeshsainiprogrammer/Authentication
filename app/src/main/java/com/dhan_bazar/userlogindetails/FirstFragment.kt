package com.dhan_bazar.userlogindetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.dhan_bazar.userlogindetails.databinding.FragmentFirstBinding


@Suppress("UNREACHABLE_CODE")
class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentFirstBinding.inflate(inflater, container, false)


        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.nextButton1.setOnClickListener {
            Log.d("TAG", "onCreateView: this is hsow")
            viewPager?.currentItem = 1
        }
        return binding.root
    }


}