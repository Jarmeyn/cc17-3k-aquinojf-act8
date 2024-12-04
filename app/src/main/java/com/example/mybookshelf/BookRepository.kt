package com.example.mybookshelf


class BooksRepository(private val apiService: BooksApiService) {
    suspend fun searchBooks(query: String): List<Book> {
        return apiService.searchBooks(query).items.map {
            Book(
                id = it.id,
                title = it.volumeInfo.title,
                thumbnailUrl = it.volumeInfo.imageLinks?.thumbnail?.replace("http", "https")
            )
        }
    }
}