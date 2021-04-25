package rx.quiz.collections

import java.util.*

class BeginnerOptionalsSolution : BeginnerOptionalsKoan() {
    override fun existingOptionals(input: List<Optional<Int>>): List<Int> {
        return input
                .filter { it.isPresent }
                .map { it.get() }
    }
}
