package com.capstone.baliguide_app.data.api

import com.capstone.baliguide_app.data.apiresponse.CafeApiResponse
import com.capstone.baliguide_app.data.apiresponse.FoodApiResponse
import com.capstone.baliguide_app.data.apiresponse.HotelApiResponse
import com.capstone.baliguide_app.data.apiresponse.SouvenirApiResponse
import com.capstone.baliguide_app.data.apiresponse.TourismApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("cafe")
    fun getCafe(

    ): Call<CafeApiResponse>

    @GET("hotels")
    fun getHotel(

    ): Call<HotelApiResponse>

    @GET("souvenir")
    fun getSouvenir(

    ): Call<SouvenirApiResponse>

    @GET("food")
    fun getFood(

    ): Call<FoodApiResponse>

    @GET("touris")
    fun getTourism(

    ): Call<TourismApiResponse>
}