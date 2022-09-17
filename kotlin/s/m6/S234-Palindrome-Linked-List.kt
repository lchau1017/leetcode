

import ListNode

class `S234-Palindrome-Linked-List` {
    fun isPalindrome(head: ListNode?): Boolean {
        if(head == null) return true
        var myList: MutableList<Int> = mutableListOf<Int>()
        var tmpHead = head
        while(tmpHead != null) {
            myList.add(tmpHead.`val`)
            tmpHead = tmpHead.next
        }
        for(i in 0..(myList.count()/2))
        {
            if (myList[i] != myList[myList.count() - 1 - i])
                return false;
        }
        return true

    }
}

