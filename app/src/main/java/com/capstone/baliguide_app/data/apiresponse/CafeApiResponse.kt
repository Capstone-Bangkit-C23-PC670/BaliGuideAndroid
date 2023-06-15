package com.capstone.baliguide_app.data.apiresponse

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class CafeApiResponse(

	@field:SerializedName("data")
	val data: List<CafeItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class CafeItem(
	@SerializedName("Opened")
	val opened: String? = null,

	@SerializedName("OpenHours")
	val openHours: String? = null,

	@SerializedName("Nama")
	val nama: String? = null,

	@SerializedName("Description")
	val description: String? = null,

	@SerializedName("Closed")
	val closed: String? = null,

	@SerializedName("Rating")
	val rating: Any? = null,

	@SerializedName("PhoneNumber")
	val phoneNumber: String? = null,

	@SerializedName("ID")
	val iD: Int? = null,

	@SerializedName("ImgUrl")
	val imgUrl: String? = null,

	@SerializedName("Location")
	val location: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Float::class.java.classLoader) as Any?,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as Int?,
		parcel.readString(),
		parcel.readString()
	)

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(opened)
		parcel.writeString(openHours)
		parcel.writeString(nama)
		parcel.writeString(description)
		parcel.writeString(closed)
		parcel.writeValue(rating)
		parcel.writeString(phoneNumber)
		parcel.writeValue(iD)
		parcel.writeString(imgUrl)
		parcel.writeString(location)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<CafeItem> {
		override fun createFromParcel(parcel: Parcel): CafeItem {
			return CafeItem(parcel)
		}

		override fun newArray(size: Int): Array<CafeItem?> {
			return arrayOfNulls(size)
		}
	}
}
