
class `26-remove-duplicates-from-sorted-array` {

    fun removeDuplicates(nums: IntArray): Int {
        var cnt = if (nums.isNotEmpty()) 1 else 0

        for (i in 1 until nums.size) {
            if (nums[i] == nums[i-1]) continue
            nums[cnt] = nums[i]
            cnt++
        }
        return cnt
    }


}

fun main() {
    val nums = intArrayOf(1, 1, 1, 1, 2, 2, 3)

    val result = `26-remove-duplicates-from-sorted-array`().removeDuplicates(nums)

    println(result)
}