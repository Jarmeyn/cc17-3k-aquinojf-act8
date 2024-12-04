package com.example.mybookshelf


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : ComponentActivity() {

    // ViewModel initialization using the 'viewModels' property delegate
    private val booksViewModel: BooksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the RecyclerView from the layout
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Initialize the adapter
        val adapter = BooksAdapter()
        recyclerView.adapter = adapter

        // Observe the books LiveData from the ViewModel
        booksViewModel.books.observe(this) { books ->
            adapter.submitList(books)
        }
    }
}
