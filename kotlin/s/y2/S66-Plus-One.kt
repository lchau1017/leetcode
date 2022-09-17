class `S66-Plus-One` {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size-1 downTo 0) {
            digits[i] += 1

            if (digits[i] <= 9)
                return digits

            digits[i] = 0
        }

        return IntArray(digits.size+1).also{ it[0] = 1 }
    }
}

fun main() {
    val result = `S66-Plus-One`().plusOne(intArrayOf(9,9,9))
    println(result.contentToString())
}
