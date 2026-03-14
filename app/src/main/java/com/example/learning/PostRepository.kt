package com.example.learning

class PostRepository {

    private val api = RetrofitClient.api

    suspend fun fetchPosts(): Resource<List<Post>> {
        return try {
            val posts = api.getPosts()
            Resource.Success(posts)
        } catch (e: Exception) {
            Resource.Error("Failed to fetch posts: ${e.message}")
        }
    }
}