package dataStructure

class ArrayQueue(private var queue: ArrayList<Int> = arrayListOf()) {
    //fifo
    fun enqueue(data: Int) {
        try {
            queue.add(data)
        } catch (e: OutOfMemoryError) {
            println(e)
            return
        }
    }

    fun dequeue(): Int? {
        return try {
            queue.removeLast()
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("Underflow")
            return null
        }
    }

    fun traverse() {
        println("Current Stack")
        val items = queue.asReversed().iterator()
        for (item in items) {
            println("$item")
        }
        println("-------\n")
    }
}

class LinkedListQueue(
    private var first: Node? = null,
    private var last: Node? = null
) {
    constructor(value: Int) : this() {
        first = Node(value, null)
        last = Node(value, null)
    }

    fun enqueue(data: Int) {
        val oldLast = last
        last = Node(data, null)
        oldLast?.next = last
    }

    fun dequeue(): Int? {
        val item = first?.value
        first = first?.next
        return item
    }

    fun traverse() {
        var currNode = first
        println("Current Queue")
        while (currNode != null) {
            println("${currNode.value}")
            currNode = currNode.next
        }
        println("-------\n")
    }
}
