//package com.example.projectexam.ui.model.news
//
//import com.google.gson.annotations.SerializedName

package com.example.projectexam.ui.model.news

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
//
//data class NewsResponse(
//    var name: String,
//    @SerializedName("latin_name")
//    var latinName: String,
//    @SerializedName("animal_type")
//    var animalType: String,
//    @SerializedName("active_time")
//    var activeTime: String,
//    @SerializedName("length_min")
//    var lengthMin: String,
//    @SerializedName("length_max")
//    var lengthMax: String,
//    @SerializedName("weight_min")
//    var weightMin: String,
//    @SerializedName("weight_max")
//    var weightMax: String,
//    @SerializedName("lifespan")
//    var lifespan: String,
//    @SerializedName("habitat")
//    var habitat: String,
//    @SerializedName("diet")
//    var diet: String,
//    @SerializedName("geo_range")
//    var geoRange: String,
//    @SerializedName("image_link")
//    var imageLink: String,
//    @SerializedName("id")
//    var id: String,
//)