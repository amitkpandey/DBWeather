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

package com.dbeginc.dbweather.intro.chooselocation

import com.dbeginc.dbweather.base.IPresenter
import com.dbeginc.dbweather.base.IView
import com.dbeginc.dbweather.viewmodels.weather.LocationWeatherModel

/**
 * Created by darel on 29.09.17.
 *
 * Choose Weather Location
 */
interface ChooseLocationContract {

    interface ChooseLocationView : IView {

        fun displayLocations(locations: List<LocationWeatherModel>)

        fun defineCurrentLocation(latitude: Double, longitude: Double, locationName: String)

        fun showLoadingStatus()

        fun hideLoadingStatus()

        fun showLocationAnimation()

        fun hideLocationAnimation()

        fun showError(message: String)

        fun goToMainScreen()
        fun onSearchQuery(query: String?)
    }

    interface ChooseLocationPresenter : IPresenter<ChooseLocationView> {
        fun loadLocations(query: String)

        fun onLocationSelected(location: LocationWeatherModel)
    }

}