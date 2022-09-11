

class `268-Missing-Number` {
    fun missingNumber(nums: IntArray): Int {
        var missing = nums.size
        for(i in nums.indices){
            missing = missing xor i xor nums[i]
        }

        return missing

    }
}
