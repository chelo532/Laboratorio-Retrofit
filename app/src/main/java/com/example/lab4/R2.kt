package com.example.lab4

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//Clase de Retrofit 2
class R2() {

    private var urls: ApiRest
    var link = links()

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(link.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        urls = retrofit.create(ApiRest::class.java)
    }

    fun getService(): ApiRest{
        return urls
    }
}