package satyam.andyprojects.repository

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import satyam.andyprojects.itunemvvm.MainActivity
import satyam.andyprojects.model.Results

class RetroClass {

    var ROOTURL = " https://itunes.apple.com/"

    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(ROOTURL)
            .addConverterFactory(GsonConverterFactory.create()).build()

    }

    fun getAPIService(): APIService {
        return getRetroInstance().create(APIService::class.java)
    }


}