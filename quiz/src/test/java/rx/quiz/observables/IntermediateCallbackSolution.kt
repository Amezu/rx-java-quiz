package rx.quiz.observables

import io.reactivex.Observable
import java.util.function.Consumer

class IntermediateCallbackSolution : IntermediateCallbackKoan() {
    override fun createLazyObservableFromCallback(callbackBasedInterface: CallbackBasedInterface): Observable<Int> {
        return Observable.create<Int> { emitter ->
            callbackBasedInterface.registerCallback(Consumer {
                emitter.onNext(it)
            }).also {
                emitter.setCancellable(it)
            }
        }
    }
}
