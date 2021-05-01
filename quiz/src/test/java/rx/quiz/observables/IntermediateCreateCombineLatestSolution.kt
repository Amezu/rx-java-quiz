package rx.quiz.observables

import io.reactivex.Observable
import io.reactivex.functions.BiFunction

class IntermediateCreateCombineLatestSolution : IntermediateCreateCombineLatestKoan() {
    override fun <T : Any, D : Any, I : Any> combineLatest(
        first: Observable<T>,
        second: Observable<D>,
        combiner: BiFunction<T, D, I>
    ): Observable<I> {
        return Observable.create { emitter ->
            var latestFirst: T? = null
            var latestSecond: D? = null

            first.subscribe { a ->
                latestFirst = a
                latestSecond?.let { b ->
                    emitter.onNext(combiner.apply(a, b))
                }
            }

            second.subscribe { b ->
                latestSecond = b
                latestFirst?.let { a ->
                    emitter.onNext(combiner.apply(a, b))
                }
            }
        }
    }
}
