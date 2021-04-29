package rx.quiz.basics

import io.reactivex.Observable
import io.reactivex.Single

class IntermediateOperatorsKoanImpl : IntermediateOperatorsKoan() {
    override fun sumOfEvenNumbers(numbers: Observable<String>): Single<Int> {
        return numbers.map { it.toInt() }
                .filter { it % 2 == 0 }
                .reduce(0, { t1, t2 -> t1 + t2 })
    }
}
