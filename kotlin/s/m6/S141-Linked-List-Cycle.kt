

import ListNode

class `S141-Linked-List-Cycle` {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        var slowPointer = head
        var fastPointer = head.next?.next
        while (fastPointer != null) {
            if (slowPointer === fastPointer) return true
            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next?.next
        }
        return false
    }
}

