package rx.quiz.observables

import io.reactivex.Observable
import java.util.function.Supplier

class IntermediateCreateLazyObservableSolution : IntermediateCreateLazyObservableKoan() {
    override fun createLazyObservableFromSupplier(supplier: Supplier<String>): Observable<String> {
        return Observable.fromCallable {
            supplier.get()
        }.repeat(3)
    }
}
