package com.example.mybookshelf


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BookResponse

    @GET("volumes/{id}")
    suspend fun getBookDetails(@Path("id") id: String): BookResponse
}
