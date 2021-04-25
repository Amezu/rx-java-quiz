package rx.quiz.combining

import io.reactivex.Observable
import io.reactivex.Scheduler
import java.util.concurrent.TimeUnit

class BeginnerCombineTimersSolution : BeginnerCombineTimersKoan() {
    override fun emitValuesAtGivenTime(scheduler: Scheduler): Observable<Long> {
        return Observable.timer(5, TimeUnit.SECONDS, scheduler)
                .mergeWith(Observable.timer(15, TimeUnit.SECONDS, scheduler))
                .mergeWith(Observable.timer(60, TimeUnit.SECONDS, scheduler))
    }
}
