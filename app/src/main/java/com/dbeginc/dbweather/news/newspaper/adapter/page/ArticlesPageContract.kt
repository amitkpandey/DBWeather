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

package com.dbeginc.dbweather.news.newspaper.adapter.page

import com.dbeginc.dbweather.base.IPresenter
import com.dbeginc.dbweather.base.IView
import com.dbeginc.dbweather.viewmodels.news.ArticleModel

/**
 * Created by darel on 10.10.17.
 *
 * Articles Page Contract
 */
interface ArticlesPageContract {

    interface ArticlesPageView : IView {
        fun displayArticles(articles: List<ArticleModel>)
    }

    interface ArticlesPagePresenter : IPresenter<ArticlesPageView> {
        fun loadArticles()

        fun updateModel(articles: List<ArticleModel>)
    }
}