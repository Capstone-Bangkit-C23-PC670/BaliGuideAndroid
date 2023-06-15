package com.capstone.baliguide_app.ui.tourism

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.baliguide_app.data.api.ApiConfig
import com.capstone.baliguide_app.data.apiresponse.TourismApiResponse
import com.capstone.baliguide_app.data.apiresponse.TourismItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TourismViewModel : ViewModel() {

    private val _tourismResponse = MutableLiveData<List<TourismItem>?>()
    val tourismResponse: LiveData<List<TourismItem>?> = _tourismResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "SouvenirViewModel"
    }

    init {
        findFoods()
    }

    fun findFoods() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getTourism()
        client.enqueue(object : Callback<TourismApiResponse> {
            override fun onResponse(
                call: Call<TourismApiResponse>,
                response: Response<TourismApiResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _tourismResponse.value = response.body()?.data as List<TourismItem>?
                }
                else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TourismApiResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}