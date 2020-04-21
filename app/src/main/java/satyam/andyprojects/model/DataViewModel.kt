package satyam.andyprojects.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import satyam.andyprojects.itunemvvm.MainActivity
import satyam.andyprojects.repository.APIService
import satyam.andyprojects.repository.RetroClass

class DataViewModel : ViewModel() {

    val results = MutableLiveData<ArtistDetails>()

    fun getAllDet(queryText: String?): MutableLiveData<ArtistDetails> {

        val apiService: APIService = RetroClass().getAPIService()

        apiService.getAllDetails("search?term=$queryText")
            .enqueue(object : Callback<ArtistDetails> {
                override fun onFailure(call: Call<ArtistDetails>, t: Throwable) {
                    Log.e("SATTY", "onFailure${t.message}")
                }

                override fun onResponse(
                    call: Call<ArtistDetails>,
                    response: Response<ArtistDetails>
                ) {
                    Log.e("SATTY", "onResponse")
                    val resultsData = response.body()

                    results.postValue(resultsData)
                }

            })

        return results
    }


}



