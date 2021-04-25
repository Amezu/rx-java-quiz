package rx.quiz.observables

import io.reactivex.Single
import java.util.function.Supplier

class BeginnerCreateLazySingleSolution : BeginnerCreateLazySingleKoan() {
    override fun createLazySingle(supplier: Supplier<Int>): Single<Int> {
        return Single.fromCallable { supplier.get() }
    }
}
