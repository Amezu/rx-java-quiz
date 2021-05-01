package rx.quiz.combining

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import java.util.concurrent.TimeUnit

class IntermediateCombineTimersSolution : IntermediateCombineTimersKoan() {
    override fun timeoutIfFirstElementDoesNotArriveIn(scheduler: Scheduler, delay: Long, unit: TimeUnit): ObservableTransformer<String, String> {
        return ObservableTransformer { upstream ->
            upstream.take(1)
                    .timeout(delay, unit, scheduler)
        }
    }
}
