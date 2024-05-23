package com.dhan_bazar.userlogindetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dhan_bazar.softwarelab.OnBoardingFragment
import com.dhan_bazar.userlogindetails.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance();

        val currentUser = mAuth!!.currentUser
        if (currentUser != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OnBoardingFragment())
                .commit()
        }

    }
}