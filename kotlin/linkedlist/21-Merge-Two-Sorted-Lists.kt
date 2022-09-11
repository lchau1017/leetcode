import ListNode

class `21-Merge-Two-Sorted-Lists` {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummy = ListNode(-1)
        var r1 = l1
        var r2 = l2
        var rr = dummy

        while (r1 != null && r2 != null) {

            if (r1.`val` <= r2.`val`) {
                rr.next = r1
                r1 = r1.next
            } else {
                rr.next = r2
                r2 = r2.next
            }
            rr = rr.next!!
        }

        if (r1 == null) {
            rr.next = r2
        }
        if (r2 == null) {
            rr.next = r1
        }

        return dummy.next
    }
}

fun main() {

    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(3)

    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next!!.next = ListNode(5)
    l2.next!!.next!!.next = ListNode(7)


    val result = `21-Merge-Two-Sorted-Lists`().mergeTwoLists(l1, l2)
    println(result)
}