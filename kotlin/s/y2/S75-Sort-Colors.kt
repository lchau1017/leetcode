
class `S75-Sort-Colors` {

    fun sortColors(nums: IntArray): Unit {

        var left = 0
        var index = 0
        var right = nums.size-1

        while (index <= right) {
            when (nums[index]) {
                0 -> {
                    nums[index] = nums[left].also { nums[left] = nums[index]}
                    index++
                    left++
                }
                2 -> {
                    nums[index] = nums[right].also { nums[right] = nums[index]}
                    right--
                }
                else -> index++
            }
        }
    }
}
