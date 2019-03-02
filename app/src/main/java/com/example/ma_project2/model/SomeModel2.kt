package com.example.ma_project2.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class SomeModel2(private val someModel: ArrayList<SomeModel>?, private val last_name: String) : Parcelable {

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeTypedList(someModel)
        parcel.writeString(last_name)
    }

    companion object {

        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<SomeModel2> = object : Parcelable.Creator<SomeModel2> {
            override fun createFromParcel(parcel: Parcel): SomeModel2 {
                val someModel = parcel.createTypedArrayList(SomeModel.CREATOR)
                val last_name = parcel.readString()
                return SomeModel2(someModel, last_name)
            }

            override fun newArray(size: Int): Array<SomeModel2?> {
                return arrayOfNulls(size)
            }
        }
    }
}
