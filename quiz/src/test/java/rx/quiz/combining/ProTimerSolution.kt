package rx.quiz.combining

import io.reactivex.Observable
import io.reactivex.Scheduler
import java.util.concurrent.TimeUnit

class ProTimerSolution : ProTimerKoan() {
    override fun sayWordsOfTheSentenceWithPausesBetweenThem(
        scheduler: Scheduler,
        phrase: String,
        pauses: List<Long>
    ): Observable<String> {
        val words = phrase.split(" ")
        return Observable.range(0, phrase.length)
            .concatMap { Observable.just(it).delay(pauses[it], TimeUnit.SECONDS, scheduler) }
            .map { words[it] }
    }
}
