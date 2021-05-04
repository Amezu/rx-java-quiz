package rx.quiz.collections

class IntermediateStringsSolution : IntermediateStringsKoan() {
    override fun removeDuplicatesInString(input: String): String {
        return input.toLowerCase()
            .split(' ')
            .map {
                it.toCharArray()
                    .distinct()
                    .joinToString("")
            }.distinct()
            .joinToString(" ")
    }
}
