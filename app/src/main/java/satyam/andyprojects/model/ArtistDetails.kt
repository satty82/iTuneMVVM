package satyam.andyprojects.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ArtistDetails(
    @SerializedName("resultCount") val totalCount: Int? = null,
    @SerializedName("results") val results: ArrayList<Results>
) : Serializable


data class Results(

    @SerializedName("artistName") var artistName: String? = null,
    @SerializedName("collectionName") var collectionName: String? = null,
    @SerializedName("trackName") var trackName: String? = null,
    @SerializedName("collectionCensoredName") var collectionCensoredName: String? = null,
    @SerializedName("trackCensoredName") var trackCensoredName: String? = null,
    @SerializedName("collectionArtistName") val collectionArtistName: String? = null
) : Serializable




