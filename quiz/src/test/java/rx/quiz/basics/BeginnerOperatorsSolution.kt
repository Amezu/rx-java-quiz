package rx.quiz.basics

import io.reactivex.Observable
import java.util.*

class BeginnerOperatorsSolution : BeginnerOperatorsKoan() {
    override fun allowOnlyExistingOptionalsThrough(input: Observable<Optional<Int>>): Observable<Int> {
        return input
                .filter { it.isPresent }
                .map { it.get() }
    }
}
