
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }
 */

class `S341-Flatten-Nested-List-Iterator` {
//    val stack = Stack<NestedInteger>()
//
//    init {
//        for (i in nestedList.size - 1 downTo 0) {
//            stack.push(nestedList[i])
//        }
//    }
//
//    fun next(): Int {
//        if (!hasNext()) throw NoSuchElementException()
//        return stack.pop().getInteger()
//    }
//
//    fun hasNext(): Boolean {
//        while (!stack.isEmpty() && !stack.peek().isInteger()) {
//            val list = stack.pop().getList()
//            for (i in list.size - 1 downTo 0) {
//                stack.push(list[i])
//            }
//        }
//        return !stack.isEmpty()
//    }
}

