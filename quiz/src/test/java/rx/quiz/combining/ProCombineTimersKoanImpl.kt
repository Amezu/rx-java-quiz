package rx.quiz.combining

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit

class ProCombineTimersKoanImpl : ProCombineTimersKoan() {
    override fun timeoutIfFirstElementDoesNotArriveIn(
        scheduler: Scheduler,
        delay: Long,
        unit: TimeUnit
    ): ObservableTransformer<String, String> {
        return ObservableTransformer { upstream ->
            upstream.timeout(
                Observable.timer(delay, unit, scheduler),
                Function<String, ObservableSource<Any>> { Observable.never() }
            )
        }
    }
}
