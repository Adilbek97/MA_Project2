package com.example.ma_project2.example_for_retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ExampleModel {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("age")
    @Expose
    var age: Int = 0
}
