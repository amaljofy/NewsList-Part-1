package digital.lamp.dagger_test.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Amal Jofy Dept. on 03,March,2020
 */
data class ResultsResponse<T>(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<T>
)