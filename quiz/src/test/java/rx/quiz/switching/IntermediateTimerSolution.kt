package rx.quiz.switching

import io.reactivex.Observable
import io.reactivex.Scheduler
import java.util.concurrent.TimeUnit

class IntermediateTimerSolution : IntermediateTimerKoan() {
    override fun whoaSlowDown(scheduler: Scheduler): Observable<Long> {
        return Observable.timer(3, TimeUnit.SECONDS, scheduler)
            .concatWith(Observable.timer(4, TimeUnit.SECONDS, scheduler))
            .concatWith(Observable.timer(5, TimeUnit.SECONDS, scheduler))
    }
}
