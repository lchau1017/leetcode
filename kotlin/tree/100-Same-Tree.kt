
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class `100-Same-Tree` {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null)
            return true

        if (p == null || q == null || p.`val` != q.`val`)
            return false

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}