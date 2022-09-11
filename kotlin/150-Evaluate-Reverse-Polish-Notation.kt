

import java.util.*

class `150-Evaluate-Reverse-Polish-Notation` {
    fun performOperationWithToken(token: String, stack: Stack<Int>): Int {
        val y = stack.pop()
        val x = stack.pop()
        return when (token) {
            "+" -> x + y
            "-" -> x - y
            "*" -> x * y
            else -> x / y
        }
    }

    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        for (token in tokens) {
            stack.push(
                when (token) {
                    "+", "-", "*", "/" -> performOperationWithToken(token, stack)
                    else -> token.toInt()
                }
            )
        }
        return stack.pop()
    }
}