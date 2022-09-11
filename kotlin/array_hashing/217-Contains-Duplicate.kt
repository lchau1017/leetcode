
class `217-Contains-Duplicate` {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hs = HashSet<Int>()
        for (e in nums)
            if (!hs.add(e)) return true
        return false
    }
}
