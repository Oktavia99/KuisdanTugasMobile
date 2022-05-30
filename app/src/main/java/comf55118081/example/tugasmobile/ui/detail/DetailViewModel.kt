package comf55118081.example.tugasmobile.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import comf55118081.example.tugasmobile.RetrofitClient
import comf55118081.example.tugasmobile.data.model.DetailUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {
    val user = MutableLiveData<DetailUser>()

    fun setUserDetail(username : String) {
        RetrofitClient.apiInstance
            .getUserDetail(username)
            .enqueue(object: Callback<DetailUser> {
                override fun onResponse(call: Call<DetailUser>, response: Response<DetailUser>) {
                    if (response.isSuccessful) {
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailUser>, t: Throwable) {
                    Log.d("Failure", t.message.toString())
                }

            })
    }

    fun getUserDetail(): LiveData<DetailUser> {
        return user
    }

}