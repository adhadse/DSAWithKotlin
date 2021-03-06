package dataStructure


class CircularLinkedList(
    private var first: Node? = null,
    private var last: Node? = null
) {
    var total: Int = 0

    /**
     *  Insertion
     */
    fun insertAtFront(data: Int) {
        val oldFirst = first
        this.first = try {
            Node(data, oldFirst)
        } catch (e: OutOfMemoryError) {
            println(e)
            return
        }
        if(last == null){
            last = first
        }
        total += 1
    }

    fun insertAtEnd(data: Int) {
        val newLast = try {
            Node(data, first)
        } catch (e: OutOfMemoryError) {
            println(e)
            return
        }
        if (first == null){
            first = newLast
        } else {
            last?.next = newLast
        }
        last = newLast //setting newNode at last node
        total += 1
    }

    /**
     *  deletion
     */
    fun deleteAtFront() {
        first = first?.next
        last?.next = first
        total -= total
    }

    fun deleteAtLast() {
        var currNode = first
        var prevNode = last
        while (currNode != last) {
            prevNode = currNode
            currNode = currNode?.next
        }
        prevNode?.next = first
        total -= total
    }

    fun traverse() {
        var currNode = first
        var count = 1
        println("First")
        do {
            println("Node No: $count | Node Value: ${currNode?.value}")
            count += 1
            currNode = currNode?.next
        } while (currNode != last)
        println("Last | Total: $total")
    }
}