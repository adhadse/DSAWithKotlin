package dataStructure

class ArrayStack{
    private var stack = arrayListOf<Int>()
    private var total = 0

    fun push(data: Int){
        if (total <= 0){
            total = 0
        }
        try { stack.add(data) }
        catch (e:OutOfMemoryError){
            println(e)
            return
        }
        total = total.inc()
    }
    fun pop():Int?{
        if (total <= 0){
            println("UNDERFLOW")
            return null
        }
        val item = stack.last()
        stack.removeLast()

        total = total.dec()
        return item
    }
    fun traverse(){
        println("Current Stack")
        val items = stack.asReversed().iterator()
        for (item in items){
            println("$item")
        }
        println("-------\nTotal: $total \n")
    }

}

class LinkedListStack(private var first: Node? = null){
    private var total = 0

    fun push(data: Int){
        if (total<=0){
            total = 0
        }
        val oldFirst = first
        first = try { Node(data, oldFirst) }
                catch (e:OutOfMemoryError){
                    println(e)
                    return
                }

        total = total.inc()
    }
    fun pop(): Int?{
        if (total <= 0){
            println("UNDERFLOW\n")
            return null
        }
        val item = first?.value
        first = first?.next
        total = total.dec()
        return item
    }
    fun traverse(){
        var currNode = first
        println("Current Stack")
        while (currNode != null) {
            println("${currNode.value}")
            currNode = currNode.next
        }
        println("-------\nTotal: $total \n")
    }
}