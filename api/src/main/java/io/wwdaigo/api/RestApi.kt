package io.wwdaigo.api

import io.wwdaigo.api.commons.BASE_URL
import io.wwdaigo.api.repository.MovieRequest
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by daigomatsuoka on 15/07/17.
 */
class RestApi {

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    val movieRequest: MovieRequest by lazy {
        retrofit.create(MovieRequest::class.java)
    }
}