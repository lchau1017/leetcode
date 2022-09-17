import java.util.*

class `23-Merge-K-Sorted-Lists` {


    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<ListNode> { a, b -> a.`val` - b.`val` }
        for (list in lists) {
            if (list != null) {
                queue.add(list)
            }
        }

        var head: ListNode? = null
        var last: ListNode? = null
        while (queue.isNotEmpty()) {
            val top = queue.peek()
            queue.remove()
            if (top?.next != null) {
                queue.add(top.next)
            }
            if (head == null) {
                head = top
                last = top
            } else {
                last?.next = top
                last = top
            }
        }
        return head
    }


//    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
//        if (lists.isEmpty()) return null
//        var mergeInterval = 1
//        while (mergeInterval < lists.size) {
//            for (i in 0..lists.lastIndex step mergeInterval * 2) {
//                lists[i] = merge(lists[i], if (i + mergeInterval <= lists.lastIndex) lists[i + mergeInterval] else null)
//            }
//            mergeInterval *= 2
//        }
//        return lists[0]
//    }
//
//    private fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
//        val dummyNode = ListNode(-1)
//        var currentNodeInList1 = l1
//        var currentNodeInList2 = l2
//        var currentNodeInResultantList: ListNode? = dummyNode
//
//        while(currentNodeInList1!=null && currentNodeInList2!=null){
//            if (currentNodeInList1.`val`>=currentNodeInList2.`val`){
//                currentNodeInResultantList?.next = currentNodeInList2
//                currentNodeInList2 = currentNodeInList2.next
//            }else{
//                currentNodeInResultantList?.next = currentNodeInList1
//                currentNodeInList1 = currentNodeInList1.next
//            }
//            currentNodeInResultantList = currentNodeInResultantList?.next
//        }
//
//        currentNodeInResultantList?.next = when{
//            currentNodeInList1!=null -> currentNodeInList1
//            currentNodeInList2!=null -> currentNodeInList2
//            else -> null
//        }
//        return dummyNode.next
//    }
}

fun main() {

    val l1 = ListNode(3)
    l1.next = ListNode(7)
    l1.next!!.next = ListNode(20)

    val l2 = ListNode(2)
    l2.next = ListNode(4)
    l2.next!!.next = ListNode(8)


    val l3 = ListNode(1)
    l3.next = ListNode(6)
    l3.next!!.next = ListNode(11)
    val result = `23-Merge-K-Sorted-Lists`().mergeKLists(arrayOf(l1, l2,l3))
    println(result)
}

