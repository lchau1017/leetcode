import java.util.*

class `125-Valid-Palindrome` {
    fun isPalindrome(s: String): Boolean {
        val s = s.lowercase(Locale.getDefault())
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            while (!s[i].isLetterOrDigit() && i < j)
                i++
            while (!s[j].isLetterOrDigit() && j > i)
                j--
            if (s[i++] != s[j--]) return false
        }
        return true
    }
}


fun main() {
    val result = `125-Valid-Palindrome`().isPalindrome(" 123 21")
    println(result)
}
