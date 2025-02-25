package rx.quiz.switching

import io.reactivex.Observable

class IntermediateSwitchingSolution : IntermediateSwitchingKoan() {
    override fun monitorWeather(
        locationApi: LocationApi,
        weatherApi: WeatherApi
    ): Observable<String> {
        return locationApi.currentLocation()
            .switchMap { currentLocation ->
                weatherApi.weatherAt(currentLocation)
            }
    }
}
