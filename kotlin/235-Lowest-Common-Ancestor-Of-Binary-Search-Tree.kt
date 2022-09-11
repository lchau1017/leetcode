

class `235-Lowest-Common-Ancestor-Of-Binary-Search-Tree` {
    fun lowestCommonAncestor(root: TreeNode, p: TreeNode?, q: TreeNode?): TreeNode? {
        var currentRoot: TreeNode? = root
        var lowestCommonAncestor: TreeNode? = null
        while (currentRoot != null) {
            if (currentRoot.`val` > p!!.`val` && currentRoot.`val` > q!!.`val`) {
                currentRoot = currentRoot.left
            } else if (currentRoot.`val` < p.`val` && currentRoot.`val` < q!!.`val`) {
                currentRoot = currentRoot.right
            } else {
                lowestCommonAncestor = currentRoot
                break
            }
        }
        return lowestCommonAncestor
    }
}