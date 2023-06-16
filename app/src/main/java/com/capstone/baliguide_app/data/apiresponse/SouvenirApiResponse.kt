package com.capstone.baliguide_app.data.apiresponse

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class SouvenirApiResponse(

	@field:SerializedName("data")
	val data: List<SouvenirItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class SouvenirItem(

	@field:SerializedName("Lokasi")
	val lokasi: String? = null,

	@field:SerializedName("Opened")
	val opened: String? = null,

	@field:SerializedName("Nama")
	val nama: String? = null,

	@field:SerializedName("Closed")
	val closed: String? = null,

	@field:SerializedName("Rating")
	val rating: Any? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("ImgUrl")
	val imgUrl: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Float::class.java.classLoader) as Any?,
		parcel.readValue(Int::class.java.classLoader) as Int?,
		parcel.readString()
	)

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(lokasi)
		parcel.writeString(opened)
		parcel.writeString(nama)
		parcel.writeString(closed)
		parcel.writeValue(rating)
		parcel.writeValue(iD)
		parcel.writeString(imgUrl)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<SouvenirItem> {
		override fun createFromParcel(parcel: Parcel): SouvenirItem {
			return SouvenirItem(parcel)
		}

		override fun newArray(size: Int): Array<SouvenirItem?> {
			return arrayOfNulls(size)
		}
	}
}
