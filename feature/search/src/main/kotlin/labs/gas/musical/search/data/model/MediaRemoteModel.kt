package labs.gas.musical.search.data.model

import com.google.gson.annotations.SerializedName

class MediaResponseRemoteModel(
    @SerializedName("resultCount") val count: Int,
    @SerializedName("results") val songs: List<MediaRemoteModel>
)

class MediaRemoteModel(
    @SerializedName("trackId") val songId: Int,
    @SerializedName("trackName") val songName: String? = "",
    @SerializedName("trackTimeMillis") val trackTimeMillis: Int,
    @SerializedName("collectionId") val albumId: String?,
    @SerializedName("collectionName") val albumName: String?,
    @SerializedName("artistId") val artistId: Int,
    @SerializedName("artistName") val artistName: String,
    @SerializedName("kind") val kind: String?,
    @SerializedName("artworkUrl100") val photo: String
)
