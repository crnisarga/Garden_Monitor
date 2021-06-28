package com.kirandroid.gardenmonitor.retrofit

import com.google.gson.JsonObject
import com.kirandroid.gardenmonitor.responses.Image
import com.kirandroid.gardenmonitor.responses.PlantIdentificationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("identify/all")
    fun PlantIdentificationResponse(@Query("images") image: Image): Call<PlantIdentificationResponse?>?



  /*  https://my-api.plantnet.org/v2/identify/all?images=https%3A%2F%2Fi.postimg.cc%2FP5q9CHjg%2FWhats-App-Image-2021-06-16-at-1-24-02-PM-4.jpg&images=https%3A%2F%2Fi.postimg.cc%2FvmrrM1Kb%2FWhats-App-Image-2021-06-16-at-1-24-02-PM-3.jpg&images=https%3A%2F%2Fi.postimg.cc%2F76TyfkgH%2FWhats-App-Image-2021-06-16-at-1-24-01-PM.jpg&organs=leaf&organs=flower&organs=fruit&include-related-images=true&lang=en&api-key=2b106yy0yLNcCZELH9t9nzUFbO
*/

}