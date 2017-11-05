/*
 *  Copyright (C) 2017 Darel Bitsy
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.dbeginc.dbweatherdata.implementations.datasources.remote.news.retrofit

import android.support.annotation.RestrictTo
import com.dbeginc.dbweatherdata.proxies.remote.news.RemoteNewsResponse
import com.dbeginc.dbweatherdata.proxies.remote.news.RemoteSourceResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by darel on 04.10.17.
 *
 * News Retrofit Api
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
interface NewsApi {
    @GET("/v1/articles")
    fun getArticles(@Query("source") source: String,
                    @Query("sortBy") sortBy: String,
                    @Query("apiKey") apiKey: String
    ) : Flowable<RemoteNewsResponse>

    @GET("/v1/sources")
    fun getSources() : Flowable<RemoteSourceResponse>
}