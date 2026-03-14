package com.example.learning

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log

class PostViewModel(private val repository: PostRepository = PostRepository()) : ViewModel() {

    val posts = MutableLiveData<Resource<List<Post>>>()  // observed by Activity

    fun fetchPosts() {
        viewModelScope.launch {
            posts.value = Resource.loading()   // show loading
            val response = repository.fetchPosts()
            posts.value = response              // Success or Error
        }
    }
}