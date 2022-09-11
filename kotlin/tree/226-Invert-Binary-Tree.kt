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
class `226-Invert-Binary-Tree` {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return root

        val left = invertTree(root.left)
        root.left = invertTree(root.right)
        root.right = left

        return root
    }
}