

import java.util.*

class `S215-Kth-Largest-Element-in-an-Array` {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // max heap
        val queue = PriorityQueue<Int>(compareBy { -it })
        nums.forEach { num ->
            queue.add(num)
        }
        repeat(k - 1) {
            queue.poll()
        }
        return queue.poll()
    }
}

