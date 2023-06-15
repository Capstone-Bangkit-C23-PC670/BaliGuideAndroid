package com.capstone.baliguide_app.ui.souvenir

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.baliguide_app.data.api.ApiConfig
import com.capstone.baliguide_app.data.apiresponse.SouvenirApiResponse
import com.capstone.baliguide_app.data.apiresponse.SouvenirItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SouvenirViewModel: ViewModel() {

    private val _souvenirResponse = MutableLiveData<List<SouvenirItem>?>()
    val souvenirResponse: LiveData<List<SouvenirItem>?> = _souvenirResponse

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
        val client = ApiConfig.getApiService().getSouvenir()
        client.enqueue(object : Callback<SouvenirApiResponse> {
            override fun onResponse(
                call: Call<SouvenirApiResponse>,
                response: Response<SouvenirApiResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _souvenirResponse.value = response.body()?.data as List<SouvenirItem>?
                }
                else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SouvenirApiResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}