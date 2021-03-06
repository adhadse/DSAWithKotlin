package dataStructure

// var/val identifier : DataType? [ This way we can declare a variable as NULLABLE ]

// classObject?.memberObjects     [ Safe Calls ]
// calls classObject.memberObjects
// ONLY IF classObject is NOT null

// identifier ?: anyValue         [ Elvis Operator :
// If the expression to the left of ?: is not null,
// the elvis operator returns it,
// otherwise it returns the expression to the right.

data class Node(
    var value: Int,
    var next: Node? = null
)

open class LinkedList(
    private var first: Node? = null,
    private var last: Node? = null
) {
    private var total: Int = 0
    private fun deleteThisNode(prevNode: Node?, currNode: Node?) {
        prevNode?.next = currNode?.next
        total -= 1
    }

    /**
     *      Insertion
     */
    fun insertAtFront(data: Int, Flag: Boolean = false) {
        val oldFirst = first
        this.first = try {
            Node(data, oldFirst)
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
            Node(data, null)
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
            insertAtFront(data)
            // if insertion never happened previously
        }
        for (i in 1..total) {
            if (i == afterNode) {
                val newNode = try {
                    Node(data, currNode?.next)
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
     *      Deletion
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

    fun deleteAtEnd(Flag: Boolean = false) {
        if (total <= 0) {
            println("UNDERFLOW")
        }
        var currNode = first
        var prevNode: Node? = null
        while (currNode != null) {
            if (currNode.next == null) {
                deleteThisNode(prevNode, currNode)
            }
            prevNode = currNode
            currNode = currNode.next
        }
        if (Flag) {
            println("End Node Deleted")
        }
    }

    fun deleteAtSpecified(NodeNo: Int, Flag: Boolean = false) {
        if (total <= 0) {
            println("UNDERFLOW")
        }
        var currNode = first
        var prevNode: Node? = null
        var i = 1
        while (currNode != null) {
            if (i == NodeNo) {
                //currNode?.next = currNode?.next?.next
                deleteThisNode(prevNode, currNode)
                if (Flag) {
                    println("Deleted Node at NodeNo : $NodeNo")
                }
            }
            i += 1
            prevNode = currNode
            currNode = currNode.next
        }
    }

    fun deleteNodesWithValue(Value: Int, Flag: Boolean = false) {
        var currNode = first
        var prevNode: Node? = null
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
