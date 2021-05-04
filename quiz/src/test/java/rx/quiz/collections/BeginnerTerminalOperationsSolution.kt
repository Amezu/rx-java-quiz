package rx.quiz.collections

class BeginnerTerminalOperationsSolution : BeginnerTerminalOperationsKoan() {
    override fun sumOfEvenNumbers(numbers: List<String>): Int {
        return numbers.mapNotNull { it.toIntOrNull() }
            .filter { it % 2 == 0 }
            .sum()
    }
}
