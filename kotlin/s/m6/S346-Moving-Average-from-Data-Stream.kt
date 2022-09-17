

import java.util.ArrayDeque

class `S346-Moving-Average-from-Data-Stream`(size: Int) {

    var q = ArrayDeque<Int>()
    var sum = 0
    val size = size

    fun next(`val`: Int): Double {
        q.offer(`val`)
        sum += `val`
        if (q.size > size) sum -= q.poll()
        return sum.toDouble() / q.size
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = MovingAverage(size)
 * var param_1 = obj.next(`val`)
 */