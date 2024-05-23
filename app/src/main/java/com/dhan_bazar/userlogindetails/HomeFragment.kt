package com.dhan_bazar.userlogindetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhan_bazar.userlogindetails.Retrofit.RetorfitClient
import com.dhan_bazar.userlogindetails.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException


class HomeFragment : Fragment() {

    //lateinit var binding: FragmentLoginBinding
    lateinit var binding: FragmentHomeBinding
    private lateinit var postAdapter: AdapterUser
    private var posts: List<UserModelsItem> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHomeBinding.inflate(inflater, container, false)
        fetchPosts()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        postAdapter = AdapterUser(posts)
        binding.recyclerView.adapter = postAdapter
        binding.progressBar.visibility = View.VISIBLE
        return binding.root
    }
    private fun fetchPosts() {
        binding.progressBar.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiService = RetorfitClient.apiServies
                val response = apiService.getPosts()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        binding.progressBar.visibility = View.GONE
                        val posts = response.body() ?: listOf()
                        Log.d("TAG", "Fetched posts: $posts")
                        postAdapter = AdapterUser(posts)

                        binding.recyclerView.adapter = postAdapter
                        // Update UI with posts
                    } else {
                        showToast("Failed to fetch posts")
                        binding.progressBar.visibility = View.GONE
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
                binding.progressBar.visibility = View.GONE
                showToast("Network error occurred")
            } catch (e: Exception) {
                e.printStackTrace()
                binding.progressBar.visibility = View.GONE
                showToast("An unexpected error occurred")
            }
        }
    }

    private fun showToast(message: String) {
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}