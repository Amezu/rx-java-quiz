package rx.quiz.observables

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Scheduler
import java.util.concurrent.TimeUnit

class IntermediateCreateIntervalSolution : IntermediateCreateIntervalKoan() {
    override fun interval(scheduler: Scheduler, period: Long, unit: TimeUnit): Observable<Int> {
        return Observable.create<Int> { emitter ->
            scheduleCounterWithDelay(period, unit, scheduler, emitter, 0)
        }
    }

    private fun scheduleCounterWithDelay(
        period: Long,
        unit: TimeUnit,
        scheduler: Scheduler,
        emitter: ObservableEmitter<Int>,
        count: Int
    ) {
        Observable.timer(period, unit, scheduler)
            .subscribe {
                emitter.onNext(count)
                scheduleCounterWithDelay(period, unit, scheduler, emitter, count + 1)
            }
    }
}
