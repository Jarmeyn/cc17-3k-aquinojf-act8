package com.example.mybookshelf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel() {
    private val repository = BooksRepository(NetworkModule.apiService)

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    init {
        fetchBooks("android")
    }

    private fun fetchBooks(query: String) {
        viewModelScope.launch {
            val result = repository.searchBooks(query)
            _books.postValue(result)
        }
    }
}
