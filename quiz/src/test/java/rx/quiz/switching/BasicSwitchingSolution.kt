package rx.quiz.switching

import io.reactivex.Single

class BasicSwitchingSolution : BasicSwitchingKoan() {
    override fun queryPinpointLocation(locationApi: LocationApi): Single<Int> {
        return locationApi.coarseLocation()
                .flatMap { locationApi.fineLocation(it) }
                .flatMap { locationApi.pinpointLocation(it) }
    }
}
