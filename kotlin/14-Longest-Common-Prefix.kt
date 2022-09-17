
class `14-Longest-Common-Prefix` {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]
        strs.sort()
        var res = ""
        for (j in strs[0].indices) {
            val c = strs[0][j]
            for (i in 1 until strs.size) {
                if (strs[i][j] != c) return res
            }
            res += c
        }
        return res
    }
}


fun main() {
//    val result = `14-Longest-Common-Prefix`().longestCommonPrefix(arrayOf("flow", "flow"))
    val result = `14-Longest-Common-Prefix`().longestCommonPrefix(arrayOf("flowernnn", "flow", "flight"))
    println(result)
}
