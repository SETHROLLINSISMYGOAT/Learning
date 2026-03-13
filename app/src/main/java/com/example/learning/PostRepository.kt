package com.example.learning

class PostRepository {

    private val api = RetrofitClient.api

    // Fetch posts from API
    suspend fun fetchPosts(): List<Post> {
        return api.getPosts()
    }
}