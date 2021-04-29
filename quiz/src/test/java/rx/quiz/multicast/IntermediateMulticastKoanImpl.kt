package rx.quiz.multicast

import io.reactivex.Observable

class IntermediateMulticastKoanImpl : IntermediateMulticastKoan() {
    override fun distributeWeatherForecasts(api: ObservableApi): Observable<String> {
        return api.observeWeather(0)
            .replay(1)
            .refCount()
    }
}
