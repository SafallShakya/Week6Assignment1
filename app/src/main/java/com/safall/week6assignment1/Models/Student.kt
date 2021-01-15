package com.safall.week6assignment1.Models

import android.os.Parcel
import android.os.Parcelable

data class Student (
    val studentName : String? = null,
    val studentImageURL : String? = null,
    val studentAddress : String? = null,
    val studentAge : Int? = null,
    val studentGender : String? = null
        ):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(studentName)
                parcel.writeString(studentImageURL)
                parcel.writeString(studentAddress)
                parcel.writeValue(studentAge)
                parcel.writeString(studentGender)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Student> {
                override fun createFromParcel(parcel: Parcel): Student {
                        return Student(parcel)
                }

                override fun newArray(size: Int): Array<Student?> {
                        return arrayOfNulls(size)
                }
        }
}
