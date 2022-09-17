

import java.util.*

class `S480-Sliding-Window-Median`{

    fun medianSlidingWindow(
        nums: IntArray,
        k: Int
    ): DoubleArray {
        if (nums.isEmpty()) return emptyArray<Double>().toDoubleArray()
        val doubleNums = nums.map { it.toDouble() }.toDoubleArray()
        // we need k > 1 to keep our pqs balanced
        if (k == 1) return doubleNums

        val isOdd = k % 2 == 1
        val answer = mutableListOf<Double>()
        // keep the higher half
        val lo = PriorityQueue<Double>()
        // keep the lower half
        val hi = PriorityQueue<Double>(compareBy { -it })

        var end = 0
        var start = 0
        (0 until k).forEach { _ -> lo.add(doubleNums[end++]) }
        // get the smaller half from lo and add them to hi
        // if k is odd, we have 1 less item in hi
        (0 until k / 2).forEach { _ -> hi.add(lo.poll()) }

        while (end <= nums.size) {
            // move window one index by one index and add the medium
            answer += if (!isOdd) {
                // even, use lo and hi to get the medium
                (lo.peek() + hi.peek()) / 2
            } else {
                // because we know that the lo will have one more item
                // than hi, the medium is there
                lo.peek()
            }
            // we reach the end of array, no need to move window
            if (end == nums.size) break
            // move window by removing the first item and adding the one at end
            val remove = doubleNums[start]
            val add = doubleNums[end]
            if (remove >= lo.peek()) {
                lo.remove(remove)
            } else {
                hi.remove(remove)
            }
            balanceHeaps(hi, lo, !isOdd)
            if (add >= lo.peek()) lo.add(add)
            else hi.add(add)

            balanceHeaps(hi, lo, isOdd)
            end++
            start++
        }
        return answer.toDoubleArray()
    }

    private fun balanceHeaps(
        hi: PriorityQueue<Double>,
        lo: PriorityQueue<Double>,
        isOdd: Boolean
    ) {
        if ((isOdd && hi.size + 1 == lo.size) || (!isOdd && hi.size == lo.size)) return
        if (lo.size <= hi.size) {
            lo.add(hi.poll())
        } else {
            hi.add(lo.poll())
        }
    }
}

//https://leetcode.com/problems/sliding-window-median/discuss/383413/kotlin-2-heaps-solution-with-explaination
