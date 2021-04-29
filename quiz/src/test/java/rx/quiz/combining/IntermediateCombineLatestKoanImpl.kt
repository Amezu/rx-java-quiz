package rx.quiz.combining

import io.reactivex.Observable
import io.reactivex.functions.Function6
import kotlin.math.min

class IntermediateCombineLatestKoanImpl : IntermediateCombineLatestKoan() {
    override fun parkingAssistant(parkingApi: ParkingApi): Observable<Sound> {
        return Observable.combineLatest(
            parkingApi.isSwitchedOn(),
            parkingApi.isRearSpeedOn(),
            parkingApi.frontLeft(),
            parkingApi.frontRight(),
            parkingApi.rearLeft(),
            parkingApi.rearRight(),
            Function6 { isSwitchedOn, isRearSpeedOn, frontLeft, frontRight, rearLeft, rearRight ->
                if (!isSwitchedOn) {
                    Sound.NONE
                } else {
                    val distance = if (isRearSpeedOn) {
                        min(rearLeft, rearRight)
                    } else {
                        min(frontLeft, frontRight)
                    }
                    when (distance) {
                        0 -> Sound.BEEEEEEEEEEEE
                        1 -> Sound.BIP_BIP_BIP_BIP
                        2 -> Sound.BEEP_BEEP_BEEP
                        3 -> Sound.BEEEP_BEEEP
                        else -> Sound.NONE
                    }
                }
            }
        )
    }
}
