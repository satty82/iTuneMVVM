package satyam.andyprojects.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
import satyam.andyprojects.model.ArtistDetails
import satyam.andyprojects.model.Results

interface APIService {

    @GET
    fun getAllDetails(@Url url: String?): Call<ArtistDetails>
    //EndPoint
}