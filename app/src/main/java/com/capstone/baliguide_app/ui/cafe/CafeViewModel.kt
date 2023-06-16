package com.capstone.baliguide_app.ui.cafe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.baliguide_app.data.api.ApiConfig
import com.capstone.baliguide_app.data.apiresponse.CafeApiResponse
import com.capstone.baliguide_app.data.apiresponse.CafeItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CafeViewModel : ViewModel() {

    private val _cafeResponse = MutableLiveData<List<CafeItem>?>()
    val cafeResponse: LiveData<List<CafeItem>?> = _cafeResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "CafeViewModel"
    }

    init {
        findCafes()
    }

    fun findCafes() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getCafe()
        client.enqueue(object : Callback<CafeApiResponse> {
            override fun onResponse(
                call: Call<CafeApiResponse>,
                response: Response<CafeApiResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _cafeResponse.value = response.body()?.data as List<CafeItem>?
                }
                else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<CafeApiResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}