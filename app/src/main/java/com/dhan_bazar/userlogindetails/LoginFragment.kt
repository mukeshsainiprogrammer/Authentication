package com.dhan_bazar.userlogindetails

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dhan_bazar.userlogindetails.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private var mAuth: FirebaseAuth? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentLoginBinding.inflate(inflater, container, false)

        mAuth = FirebaseAuth.getInstance();

        binding.forgot.setOnClickListener {

            val fragment = ForgotFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        binding.RegisterBtn.setOnClickListener {
            val fragment = RegisterFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.loginBtnButton1.setOnClickListener {
            loginUserAccount()
        }
        return binding.root
    }
    private fun ApiCallLoginUser(){
        val email = binding.emailAdress.text.toString().trim()
        val password = binding.passwordUserLogin.text.toString().trim()


    }
    private fun loginUserAccount() {
        binding.progressBar.visibility = View.VISIBLE
        val email = binding.emailAdress.text.toString()
        val password = binding.passwordUserLogin.text.toString()

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Please enter email!!", Toast.LENGTH_LONG).show()
            binding.progressBar.visibility = View.GONE
            return
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please enter password!!", Toast.LENGTH_LONG).show()
            binding.progressBar.visibility = View.GONE
            return
        }

        // Sign in existing user
        mAuth?.signInWithEmailAndPassword(email, password)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Login successful!!", Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.GONE
                    navigateToRegisterInfoFragment()
                } else {
                    Toast.makeText(context, "Login failed!!", Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.GONE
                }
            }
    }


    private fun navigateToRegisterInfoFragment() {
        val fragmentB = HomeFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragmentB)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}