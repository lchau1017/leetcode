

import TreeNode
import java.util.*

class `S1650-Lowest-Common-Ancestor-of-a-Binary-Tree-III` {

    class Node(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
        var parent: Node? = null
    }

    val set = HashSet<Node>()

    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        if (p == null && q == null) return null

        if (p != null) {
            if (set.contains(p)) return p
            else set.add(p)
        }

        if (q != null) {
            if (set.contains(q)) return q
            else set.add(q)
        }

        return lowestCommonAncestor(p?.parent, q?.parent)
    }
}
