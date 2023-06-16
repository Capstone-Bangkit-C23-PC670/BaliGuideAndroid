package com.capstone.baliguide_app.data.apiresponse

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class HotelApiResponse(

	@field:SerializedName("data")
	val data: List<HotelItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class HotelItem(

	@field:SerializedName("Lokasi")
	val lokasi: String? = null,

	@field:SerializedName("Rating")
	val rating: Any? = null,

	@field:SerializedName("Budget")
	val budget: Int? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("ImgURL")
	val imgURL: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as Any?,
		parcel.readValue(Int::class.java.classLoader) as Int?,
		parcel.readValue(Int::class.java.classLoader) as Int?,
		parcel.readString(),
		parcel.readString()
	)

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(lokasi)
		parcel.writeValue(rating)
		parcel.writeValue(budget)
		parcel.writeValue(iD)
		parcel.writeString(imgURL)
		parcel.writeString(name)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<HotelItem> {
		override fun createFromParcel(parcel: Parcel): HotelItem {
			return HotelItem(parcel)
		}

		override fun newArray(size: Int): Array<HotelItem?> {
			return arrayOfNulls(size)
		}
	}
}
