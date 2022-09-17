

class `S3-Longest-Substring-Without-Repeating-Characters` {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        // Result
        var max = 0
        // Occurance map
        var occ = mutableMapOf<Char, Int>()

        for ((i, c) in s.withIndex()) {

            if (occ.containsKey(c)) {
                // Found a clash, move the start pointer
                // next to the previous occurance if applicable
                val seekPoint = occ[c]!! + 1
                start = Math.max(seekPoint, start)
            }

            val length = i - start + 1
            max = Math.max(length, max)

            // Update the map with latest occurance
            // when clash happen next time, use this index
            occ[c] = i
        }
        return max
    }
}
