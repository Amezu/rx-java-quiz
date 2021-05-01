package rx.quiz.basics

import io.reactivex.Observable
import io.reactivex.ObservableTransformer

class ProStatefulScanSolution : ProStatefulScanKoan() {
    override fun createStringTokenizer(): ObservableTransformer<Char, Result> {
        return ObservableTransformer { upstream ->
            val sequence = mutableListOf<Char>()
            var count = 0
            var wasDot = false
            Observable.create<Result> { emitter ->
                upstream.subscribe {
                    when {
                        it.isDigit() && count == 0 -> {
                            count = it.toString().toInt()
                        }
                        it == '.' && count > 0 && !wasDot -> {
                            wasDot = true
                        }
                        it.isLetter() && count > 0 && wasDot -> {
                            sequence += it
                            if (sequence.size == count) {
                                emitter.onNext(Result(count, sequence.joinToString("")))
                                count = 0
                                sequence.clear()
                                wasDot = false
                            }
                        }
                        else -> {
                            emitter.onError(IllegalArgumentException())
                        }
                    }
                }
            }
        }
    }
}

//var count = 0
//var value = ""
//return upstream.doOnNext {
//    if (count == null) {
//        count = it.toInt()
//    } else if () {
//        value + it
//    } else {
//        return
//    }
//}
