package rx.quiz.multicast

import io.reactivex.Observable

class BeginnerMulticastSolution : BeginnerMulticastKoan() {
    override fun distributeWeatherForecasts(api: ObservableApi): Observable<String> {
        return api.observeWeather(0).share()
    }
}
