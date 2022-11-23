package com.bazuka_cafer_xd.terminalgiri

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("public/v2/users")
    fun getData(): Call<List<DATAItem>>
}