package com.mert.postmethod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mert.postmethod.data.model.Product
import com.mert.postmethod.data.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var editTextProductName: EditText
    private lateinit var editTextProductStock: EditText
    private lateinit var buttonAddProduct: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextProductName = findViewById(R.id.editTextProductName)
        editTextProductStock = findViewById(R.id.editTextProductStock)
        buttonAddProduct = findViewById(R.id.buttonAddProduct)

        buttonAddProduct.setOnClickListener {
            val productName = editTextProductName.text.toString()
            val productStock = editTextProductStock.text.toString().toIntOrNull()

            if (productName.isNotEmpty() && productStock != null) {
                val product = Product(0, productName, productStock, getCurrentDateTime())
                addProduct(product)
            } else {
                showToast("Please fill in all fields.")
            }
        }
    }

    private fun addProduct(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.addProduct(product)
                withContext(Dispatchers.Main) {
                    showToast(response.message)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showToast("Error: ${e.localizedMessage}")
                    e.printStackTrace()
                }
            }
        }
    }

    private fun getCurrentDateTime(): String {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
        return currentDateTime.format(formatter)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}