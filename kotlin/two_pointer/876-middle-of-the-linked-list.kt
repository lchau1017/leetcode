class `876-middle-of-the-linked-list` {


    fun middleNode(head: ListNode?): ListNode? {
        var fast = head
        var slow = head

        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }


}

fun main() {

    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(3)
    l1.next!!.next!!.next = ListNode(4)
    l1.next!!.next!!.next!!.next = ListNode(5)
    l1.next!!.next!!.next!!.next!!.next = ListNode(6)
    l1.next!!.next!!.next!!.next!!.next!!.next = ListNode(7)
    l1.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(8)
    l1.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(9)
    l1.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(10)
    l1.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(11)
    l1.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(12)

    val result = `876-middle-of-the-linked-list`().middleNode(l1)
    println(result?.`val`)
}