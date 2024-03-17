//ApiService.kt

package com.mert.postmethod.data.network

import com.mert.postmethod.data.model.Product
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("end-point-here")
    suspend fun addProduct(@Body product: Product): ApiResponse
}
