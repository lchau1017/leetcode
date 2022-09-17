class `160-Intersection-of-two-linked-lists` {

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var pA = headA
        var pB = headB
        while (pA != pB) {
            pA = if (pA == null) headB else pA.next
            pB = if (pB == null) headA else pB.next
        }
        return pA
    }


}

fun main() {

    val l1 = ListNode(4)
    l1.next = ListNode(1)
    l1.next!!.next = ListNode(8)
    l1.next!!.next!!.next = ListNode(4)
    l1.next!!.next!!.next!!.next = ListNode(5)

    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next!!.next = ListNode(1)
    l2.next!!.next!!.next = ListNode(8)
    l2.next!!.next!!.next!!.next = ListNode(4)
    l2.next!!.next!!.next!!.next!!.next = ListNode(5)

    val result = `160-Intersection-of-two-linked-lists`().getIntersectionNode(l1, l2)
    println(result)
}