package rx.quiz.observables

import io.reactivex.Observable
import java.util.function.Supplier

// Hot and cold: https://medium.com/tompee/rxjava-ninja-hot-and-cold-observables-19b30d6cc2fa
class BeginnerCreateEagerObservableSolution : BeginnerCreateEagerObservableKoan() {

    override fun createEagerObservableFromSupplier(supplier: Supplier<String>): Observable<String> {
        return Observable.fromCallable { supplier.get() }.repeat(3).cache()
    }
}
