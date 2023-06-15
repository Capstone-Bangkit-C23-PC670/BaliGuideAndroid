package com.capstone.baliguide_app.data.apiresponse

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TourismApiResponse(

	@field:SerializedName("data")
	val data: List<TourismItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class TourismItem(

	@field:SerializedName("EntraceFee")
	val entraceFee: Int? = null,

	@field:SerializedName("Rating")
	val rating: Any? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("ImgURL")
	val imgURL: String? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("Location")
	val location: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as Int?,
		parcel.readValue(Int::class.java.classLoader) as Any?,
		parcel.readValue(Int::class.java.classLoader) as Int?,
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	)

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(entraceFee)
		parcel.writeValue(rating)
		parcel.writeValue(iD)
		parcel.writeString(imgURL)
		parcel.writeString(name)
		parcel.writeString(location)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<TourismItem> {
		override fun createFromParcel(parcel: Parcel): TourismItem {
			return TourismItem(parcel)
		}

		override fun newArray(size: Int): Array<TourismItem?> {
			return arrayOfNulls(size)
		}
	}
}
