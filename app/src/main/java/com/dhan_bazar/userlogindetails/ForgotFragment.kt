package com.dhan_bazar.userlogindetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dhan_bazar.userlogindetails.databinding.FragmentForgotBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ForgotFragment : Fragment() {

    lateinit var binding: FragmentForgotBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotBinding.inflate(inflater, container, false)

        binding.forgotNumButton1.setOnClickListener {
            apiCallingForNum()
        }
        return binding.root
    }
    private fun apiCallingForNum(){
        /*val Num = binding.forgotNumber.text.toString().trim()

        CoroutineScope(Dispatchers.IO).launch {
            val apiServies = RetorfitClient.apiServies
            withContext(Dispatchers.Main){
                val result  = apiServies.getUserForgotNum(Num)
                try {
                    if (result.isSuccessful){
                        navigateToRegisterInfoFragment()
                        Log.d("TAG", "ApiCallLoginUser: this user Forgot successfull == ${result.body()}")
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }*/
    }

    /*private fun navigateToRegisterInfoFragment() {
        val fragment = OtpRecFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
*/
}