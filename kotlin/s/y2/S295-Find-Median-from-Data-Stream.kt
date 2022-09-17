
class `S295-Find-Median-from-Data-Stream` {
    /** initialize your data structure here. */
    private val list = mutableListOf<Int>()

    fun addNum(num: Int) {
        val index = list.binarySearch(num)
        val insert = if (index < 0) -index - 1 else index
        list.add(insert, num)
    }

    fun findMedian(): Double {
        if (list.isEmpty()) return 0.0

        val mid = list.lastIndex / 2
        return if (list.size % 2 == 0) (list[mid].toDouble() + list[mid + 1]) / 2
        else list[mid].toDouble()
    }
}
