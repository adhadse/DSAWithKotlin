package dataStructure

class CircularQueue(private val size:Int ,
                    private var queue: ArrayList<Int> = arrayListOf()  ) {
    var front = -1
    var last = -1

    fun enqueue(data: Int) {
        if ( ( front == 0 && last == size-1 ) ||
                ( last == (front-1)%(size-1) ) ) {
            println("Queue is Full")
            return
        } else
            if ( front == -1){ // Inset first Element
                front = 0
                last = 0
            } else
                if ( last == size-1 && front != 0) {
                    last = 0
                    queue[last] = data
                }
    }

    fun dequeue(): Int? {
        if (front == -1) {
            println("Queue is Empty")
            return null
        }
        val item = queue[front]
        queue[front] = -1
        if (front == last) {
            front = -1
            last = -1
        } else
            if (front == size-1) {
                front = 0
            } else
                front++
        return item
    }
}
