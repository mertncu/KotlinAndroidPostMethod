//Product.kt
package com.mert.postmethod.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("productId") val id: Int,
    @SerializedName("productName") val name: String,
    @SerializedName("productStock") val stock: Int,
    @SerializedName("productsDate") val date: String
)