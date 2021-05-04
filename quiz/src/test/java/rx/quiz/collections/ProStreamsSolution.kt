package rx.quiz.collections

class ProStreamsSolution : ProStreamsKoan() {
    override fun sortStringWithMultipleCriteria(input: String): String {
        return input
            .toLowerCase()
            .split(' ')
            .map {
                it.toCharArray()
                    .distinct()
                    .joinToString("")
            }.sortedWith(compareBy({ it.length }, { it }))
            .joinToString(" ")
    }
}
