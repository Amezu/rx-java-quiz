package rx.quiz.observables

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.addTo

class ProCreateCombineLatestSolution : ProCreateCombineLatestKoan() {
    override fun <T : Any, D : Any, I : Any> combineLatest(
        first: Observable<T>,
        second: Observable<D>,
        combiner: BiFunction<T, D, I>
    ): Observable<I> {
        val disposables = CompositeDisposable()

        return Observable.create<I> { emitter ->
            var latestFirst: T? = null
            var latestSecond: D? = null
            var completed = false

            first.doOnNext { a ->
                latestFirst = a
                latestSecond?.let { b ->
                    emitter.onNext(combiner.apply(a, b))
                }
            }.doOnError {
                emitter.onError(it)
            }.doOnComplete {
                if (latestFirst == null || completed) {
                    emitter.onComplete()
                } else {
                    completed = true
                }
            }.subscribe()
                .addTo(disposables)

            second.doOnNext { b ->
                latestSecond = b
                latestFirst?.let { a ->
                    emitter.onNext(combiner.apply(a, b))
                }
            }.doOnError {
                emitter.onError(it)
            }.doOnComplete {
                if (latestSecond == null || completed) {
                    emitter.onComplete()
                } else {
                    completed = true
                }
            }.subscribe()
                .addTo(disposables)
        }.doOnDispose {
            disposables.dispose()
        }
    }
}
