package digital.lamp.dagger_test.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 * Created by Amal Jofy Dept. on 11,March,2020
 */

@Parcelize
data class NewsItem(
    @field:SerializedName("title")
    val itemTitle: String,
    @field:SerializedName("link")
    val imageLink: String,
    @field:SerializedName("description")
    val itemDesc: String,
    @field:SerializedName("content")
    val newsContent: @RawValue NewsContent
) : Parcelable

@Parcelize
data class NewsContent(
    @field:SerializedName("_url")
    val imageThumb: String
): Parcelable
