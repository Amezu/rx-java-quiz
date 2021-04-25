package rx.quiz.collections

class BeginnerFlattenStreamsSolution : BeginnerFlattenStreamsKoan() {
    override fun flattenList(input: List<List<Int>>): List<Int> {
        return input.flatten()
    }
}
