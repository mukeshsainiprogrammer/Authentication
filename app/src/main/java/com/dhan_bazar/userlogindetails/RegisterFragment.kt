package com.dhan_bazar.userlogindetails

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dhan_bazar.userlogindetails.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    private var mAuth: FirebaseAuth? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        binding.infoFrag.setOnClickListener {
           // navigateToRegisterInfoFragment()
        }
        mAuth = FirebaseAuth.getInstance();
        binding.registerButton1.setOnClickListener {
            registerUserAccount()
        }
        return binding.root
    }
    private fun registerUserAccount() {
        binding.progressBar.setVisibility(View.VISIBLE)

        val name = binding.editFullName.text.toString().trim()
        val phone = binding.editPhone.text.toString().trim()
        val email = binding.editEmail.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()
        val rePassword = binding.RePasssword.text.toString().trim()

        // Validate inputs
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(context, "Please enter name!!", Toast.LENGTH_LONG).show()
            binding.progressBar.setVisibility(View.GONE)
            return
        }
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(context, "Please enter phone!!", Toast.LENGTH_LONG).show()
            binding.progressBar.setVisibility(View.GONE)
            return
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Please enter email!!", Toast.LENGTH_LONG).show()
            binding.progressBar.setVisibility(View.GONE)
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please enter password!!", Toast.LENGTH_LONG).show()
            binding.progressBar.setVisibility(View.GONE)
            return
        }
        if (password != rePassword) {
            Toast.makeText(context, "Passwords do not match!!", Toast.LENGTH_LONG).show()
            binding.progressBar.setVisibility(View.GONE)
            return
        }

        mAuth!!.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = mAuth!!.currentUser
                    val userId = user!!.uid
                    val userProfile = hashMapOf(
                        "uid" to userId,
                        "name" to name,
                        "phone" to phone,
                        "email" to email
                    )
                    val db = FirebaseFirestore.getInstance()
                    db.collection("users").document(userId).set(userProfile)
                        .addOnSuccessListener {
                            Toast.makeText(context, "Registration successful!!", Toast.LENGTH_LONG).show()
                            binding.progressBar.setVisibility(View.GONE)
                            navigateToRegisterInfoFragment()
                        }
                        .addOnFailureListener {
                            Toast.makeText(context, "Registration failed!!", Toast.LENGTH_LONG).show()
                            binding.progressBar.setVisibility(View.GONE)
                        }
                } else {
                    Toast.makeText(context, "Registration failed!!", Toast.LENGTH_LONG).show()
                    binding.progressBar.setVisibility(View.GONE)
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