

import java.util.*

class `S1209-Remove-All-Adjacent-Duplicates-in-String-II` {
    fun removeDuplicates(s: String, k: Int): String {
        val stack = Stack<Pair<Char, Int>>()

        for (i in s.indices) {
            if (stack.isEmpty()) {
                stack.push(Pair(s[i], 1))
                continue
            }

            val prev = stack.peek()
            if (s[i] == prev.first) {
                if (prev.second == k - 1) {
                    for (i in 0 until k - 1) {
                        stack.pop()
                    }
                } else {
                    stack.push(Pair(prev.first, prev.second + 1))
                }
            } else {
                stack.push(Pair(s[i], 1))
            }
        }

        return stack.map { it.first }.joinToString("")
    }
}
