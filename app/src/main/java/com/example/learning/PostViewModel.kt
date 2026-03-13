package com.example.learning

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log

class PostViewModel(private val repository: PostRepository = PostRepository()) : ViewModel() {

    val posts = MutableLiveData<List<Post>>()  // observed by Activity

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = repository.fetchPosts()
                posts.postValue(response) // LiveData updates RecyclerView
            } catch (e: Exception) {
                Log.e("NetworkError", "Failed to fetch posts: ${e.message}")
            }
        }
    }
}