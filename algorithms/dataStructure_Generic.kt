package algorithms

// TODO: 03-September-2020 Make every class out of DataStructure class
// TODO: 03-September-2020 Move kotlin file out of package

class DataStructure{

    //class Node<T>(var value:T?, var next:Node<T>? = null)
    class Node(var value:Int,
               var next: Node? = null)
    var total:Int = 0
    class LinkedList(private var first: Node? = null,
                     private var last: Node? = null){
        private var total: Int

        /**
         *      Insertion
         */
        fun insertFront(data:Int){
            val oldFirst = first
            this.first = Node(data,oldFirst)
            total.inc()
        }
        fun insertEnd(data: Int){
            val newLast = Node(data,null)
            last.next = newLast
            total.inc()
        }
        fun insertAtSpecified(data: Int,afterNode: Int){
            var currNode = first
            while (currNode != null) {
                if (currNode == afterNode) {
                    val newNode = Node(data, currNode.next)
                    currNode.next = newNode
                }
                currNode = currNode.next
            }
            total.inc()
        }

        /**
         *      Deletion
         */
        fun deleteFront():Int?{
            val returnItem = first?.value
            first = first?.next
            total.dec()
            return returnItem
        }
        fun deleteLast():Int?{
            //travese the node till second-last
            //val delete:(Node) -> Int =
            //traverse { delete() }
            var currNode = first
            while (currNode != null){
                if (currNode.next.next == null)
            }
            total.dec()
        }

        fun traverse(operation:() -> Unit){
            var currNode = first
            var count = 1
            while (currNode != null){
                // Any Operation You want to
                // perform during traversing
                //if (currNode != null) {
                //operation(currNode)
                //}
                currNode = currNode.next
                print("Node No: $count | Node Value: ${currNode?.value}")
            }
        }
    }
    class Stack<T>{
        var first: Node<T>
            get() {
                field = first
            }
            set(value:T){
                field = Node<T>(value, null )
            }
        fun push(data: T?){
            val oldFirst: Node<T> = first
            first = Node(data, oldFirst)
         }
        fun pop():T?{
            val item = first.value
            first = first.next ?: first
            return item
        }
    }

    class ListStack<T>{
        private var list = mutableListOf<T>()

        fun push(data: T){
            list.add(data)
        }
        fun pop():T{
            return list.removeLast()
        }
    }

    class LinkedQueue<T>(private var first: Stack.Node<T>, private var last: Stack.Node<T>){
        constructor(value: T?){
            first = Stack.Node(value,null)
            last = Stack.Node(value, null)
        }

        fun enqueue(data: T?){
            val oldlast = last
            last = Stack.Node(data,null)
            oldlast.next = last
        }
        fun dequeue(): T? {
            val item = first.value
            first = first.next ?: first
            return item
        }
    }
}

fun main(){
   val ll = DataStructure.Stack<String>("Kapil")
}