class `33_Search_In_Rotated_Sorted_Array` {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex

        while (l <= r) {
            val m = l + (r - l) / 2

            if (nums[m] == target) return m

            //left sorted portion
            if (nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1
                } else {
                    r = m - 1
                }
            } else {
                // right sorted portion
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1
                } else {
                    l = m + 1
                }
            }
        }

        return -1
    }
}

fun main() {
    val result = `33_Search_In_Rotated_Sorted_Array`().search(intArrayOf(11, 15, 2, 7, 9), 9)
    println(result)
}
