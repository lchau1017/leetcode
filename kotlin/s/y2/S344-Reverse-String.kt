
class `S344-Reverse-String` {

    fun reverseString(s: CharArray): Unit {
        recursion(s, 0)
    }

    fun recursion(s: CharArray, count: Int): CharArray {
        var n = s.size - 1
        return if (count <= (n) / 2) {
            var temp = s[count]
            s[count] = s[n-count]
            s[n-count] = temp
            recursion(s,count+1)
        } else {
            s
        }
    }
}
