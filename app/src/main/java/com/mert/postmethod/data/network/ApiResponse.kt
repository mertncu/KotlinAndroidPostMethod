//ApiResponse.kt
package com.mert.postmethod.data.network

import com.google.gson.annotations.SerializedName
import com.mert.postmethod.data.model.Product

data class ApiResponse(
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: Product?
)