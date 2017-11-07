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

package com.dbeginc.dbweatherdomain.usecases.news

import com.dbeginc.dbweatherdomain.entities.news.Article
import com.dbeginc.dbweatherdomain.entities.requests.news.NewsRequest
import com.dbeginc.dbweatherdomain.repositories.configurations.ConfigurationsRepository
import com.dbeginc.dbweatherdomain.repositories.news.NewsRepository
import com.dbeginc.dbweatherdomain.usecases.UseCase
import io.reactivex.Flowable

/**
 * Created by darel on 06.10.17.
 *
 * Get Articles Use Case
 */
class GetArticles(private val newsRepo: NewsRepository, private val configRepo: ConfigurationsRepository) : UseCase<List<Article>, NewsRequest<Unit>>() {

    override fun buildUseCase(params: NewsRequest<Unit>): Flowable<List<Article>> {
        return configRepo.getNewsPapersTranslationStatus()
                .flatMapPublisher { isTranslationOn ->
                    if (isTranslationOn) newsRepo.getTranslatedArticles(params) else newsRepo.getArticles(params)
                }
    }
    override fun clean() = newsRepo.clean()

}