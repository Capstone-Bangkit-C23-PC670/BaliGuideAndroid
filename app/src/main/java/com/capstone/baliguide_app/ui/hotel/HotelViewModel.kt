package com.capstone.baliguide_app.ui.hotel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.baliguide_app.data.api.ApiConfig
import com.capstone.baliguide_app.data.apiresponse.HotelApiResponse
import com.capstone.baliguide_app.data.apiresponse.HotelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HotelViewModel: ViewModel() {

    private val _hotelResponse = MutableLiveData<List<HotelItem>?>()
    val hotelResponse: LiveData<List<HotelItem>?> = _hotelResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "HotelViewModel"
    }

    init {
        findFoods()
    }

    fun findFoods() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getHotel()
        client.enqueue(object : Callback<HotelApiResponse> {
            override fun onResponse(
                call: Call<HotelApiResponse>,
                response: Response<HotelApiResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _hotelResponse.value = response.body()?.data as List<HotelItem>?
                }
                else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<HotelApiResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}