package rx.quiz.observables

import io.reactivex.Observable
import io.reactivex.Scheduler
import java.util.concurrent.TimeUnit

class BeginnerCreateTimerSolution : BeginnerCreateTimerKoan() {
    override fun timer(scheduler: Scheduler, delay: Long, unit: TimeUnit): Observable<Int> {
        return Observable.create<Int> {
            scheduler.scheduleDirect({
                it.onNext(0)
                it.onComplete()
            }, delay, unit)
        }
    }
}
