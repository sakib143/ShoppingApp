package com.example.shopingapp.data.repository

import com.example.shopingapp.api.SafeAPIRequest
import com.example.shopingapp.api.WebServiceInterface
import javax.inject.Inject

class HomeRepository@Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

}