package com.example.learning

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)

        recyclerView = findViewById(R.id.recycler_View)
        adapter = PostAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Observe posts LiveData
        postViewModel.posts.observe(this) { resource ->
            when(resource) {
                is Resource.loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    adapter.updatePosts(resource.data)
                }
                is Resource.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        // Fetch posts from API
        postViewModel.fetchPosts()
    }


}