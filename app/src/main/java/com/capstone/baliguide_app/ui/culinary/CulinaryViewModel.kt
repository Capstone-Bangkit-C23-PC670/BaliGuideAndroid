package com.capstone.baliguide_app.ui.culinary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.baliguide_app.data.api.ApiConfig
import com.capstone.baliguide_app.data.apiresponse.FoodApiResponse
import com.capstone.baliguide_app.data.apiresponse.FoodItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CulinaryViewModel : ViewModel() {

    private val _culinaryResponse = MutableLiveData<List<FoodItem>?>()
    val culinaryResponse: LiveData<List<FoodItem>?> = _culinaryResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "CulinaryViewModel"
    }

    init {
        findFoods()
    }

    fun findFoods() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getFood()
        client.enqueue(object : Callback<FoodApiResponse> {
            override fun onResponse(
                call: Call<FoodApiResponse>,
                response: Response<FoodApiResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _culinaryResponse.value = response.body()?.data as List<FoodItem>?
                }
                else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FoodApiResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}