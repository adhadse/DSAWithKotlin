package dataStructure

data class DbNode(
    var prev: DbNode? = null,
    var value: Int,
    var next: DbNode? = null
)

class DoublyLinkedList(
    private var first: DbNode? = null,
    private var last: DbNode? = null
) {
    private var total = 0
    private fun deleteThisNode(prevNode: DbNode?, currNode: DbNode?) {
        prevNode?.next = currNode?.next
        val nodeAfterCurrNode = currNode?.next
        nodeAfterCurrNode?.prev = prevNode
        total -= 1
    }

    /**
     *  Insertion
     */
    fun insertAtFront(data: Int, Flag: Boolean = false) {
        val oldFirst = first
        this.first = try {
            DbNode(null, data, oldFirst)
        } catch (e: OutOfMemoryError) {
            println(e)
            return
        }
        if (last == null) {
            last = first
            // the case when last is null and
            // only inserting front; last is null
            // insertAtEnd don't work without this
        }
        if (Flag) {
            println("Inserted Node at Front with Value : $data")
        }
        total += 1
    }

    fun insertAtEnd(data: Int, Flag: Boolean = false) {
        val newLast = try {
            DbNode(last, data, null)
        } catch (e: OutOfMemoryError) {
            println(e)
            return
        }
        if (first == null) {
            first = newLast
        } else {
            last?.next = newLast
        }
        if (Flag) {
            println("Inserted Node at End with Value : $data")
        }
        last = newLast
        total += 1
    }

    fun insertAtSpecified(data: Int, afterNode: Int, Flag: Boolean = false) {
        var currNode = first
        if (afterNode == 0) {
            insertAtFront(data, false)
            // if insertion never happened previously
        }
        for (i in 1..total) {
            if (i == afterNode) {
                val newNode = try {
                    DbNode(currNode?.prev, data, currNode?.next)
                } catch (e: OutOfMemoryError) {
                    println(e)
                    return
                }
                currNode?.next = newNode
                total += 1
            }
            currNode = currNode?.next
        }
        if (Flag) {
            println("Inserted Node after NodeNo: $afterNode with Value: $data")
        }
    }

    /**
     *   Deletion
     */
    fun deleteAtFront(Flag: Boolean = false): Int? {
        if (total <= 0) {
            println("UNDERFLOW")
        }
        val returnItem = first?.value
        first = first?.next
        total -= 1
        if (Flag) {
            println("Deleted Node in Front")
        }
        return returnItem
    }

    fun deleteAtEnd(Flag: Boolean = false): Int? {
        if (total <= 0) {
            println("UNDERFLOW")
        }
        val lastsPrevNode = last?.prev
        val returnItem = last?.value

        last = lastsPrevNode
        last?.next = null
        if (Flag) {
            println("End Node Deleted")
        }
        total -= 1
        return returnItem
    }

    fun deleteAtSpecified(NodeNo: Int, Flag: Boolean = false) {
        if (total <= 0) {
            println("UNDERFLOW")
        }
        var currNode = first
        var prevNode: DbNode? = null
        var i = 1
        while (currNode != null) {
            print("NodeNo:$NodeNo,I: $i\n")
            if (i == NodeNo) {
                //currNode?.next = currNode?.next?.next
                deleteThisNode(prevNode, currNode)
                if (Flag) {
                    println("Deleted Node at NodeNo : $NodeNo")
                }
                break
            }
            i++
            prevNode = currNode
            currNode = currNode.next
        }
    }

    fun deleteNodesWithValue(Value: Int, Flag: Boolean = false) {
        var currNode = first
        var prevNode: DbNode? = null
        while (currNode != null) {
            if (currNode.value == Value) {
                deleteThisNode(prevNode, currNode)
                if (Flag) {
                    println("Deleted Node(s) with Value : $Value ")
                }
            }
            prevNode = currNode
            currNode = currNode.next
        }
    }

    fun traverse() {
        var currNode = first
        var count = 1
        println("First")
        while (currNode != null) {
            println("Node No: $count | Node Value: ${currNode.value}")
            count += 1
            currNode = currNode.next
        }
        println("Last | Total: $total")
    }
}
