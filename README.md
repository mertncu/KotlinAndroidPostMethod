## PostMethod Android Application with Kotlin

This Android application allows adding a product by sending a POST request to a specific API.

# Requirements
- Android Studio
- A published web api
- Internet connection

# Installation
1. Clone or download this repository.
```bash
git clone https://github.com/mert/postmethod.git
```
2. Open Android Studio, Select File -> New -> Import Project... and choose the downloaded files.
3. fter the project is loaded, update the API URL in the BASE_URL variable in the RetrofitClient.kt file accordingly.
4. Click the "Run" button with an emulator or physical device to launch the application.

# Usage
1. Launch the application. The main screen comes with text input fields for entering the product name and stock quantity,
along with a "Add Product" button.

2. Enter the product name and stock quantity into the required fields.
3. Click the "Add Product" button to add the product.
4. You will receive a notification about the added product.
5. You can scroll down the screen to see the last added product.

# Project Structure

- data.model.Product: Product data model. Contains id, name, stock quantity, and date of the product.
- data.network.ApiResponse: API response data model. Contains a message and optionally a product.
- data.network.ApiService: API service interface used by Retrofit. Provides a POST request to add a product.
- data.network.RetrofitClient: Singleton object creating a Retrofit instance. Provides the API service.
- MainActivity: Main activity of the application. Allows adding a product.


# JSON Format 

```
{
    "productId": 1,
    "productName": "example",
    "productStock": 1,
    "productsDate": "added date"
}
```

# Notes

- This application is an example application for sending a POST request to an API using the Retrofit library.
- The API must be up and running and published.
- Adjust the Product and ApiResponse models and the ApiService accordingly to integrate the project with your own API.





