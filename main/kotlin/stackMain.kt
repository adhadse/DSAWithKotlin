import dataStructure.ArrayStack
import dataStructure.LinkedListStack

fun main(){
   runArrayStack()
    runLinkedListStack()
}

fun runArrayStack(){
    val stack = ArrayStack()
    stack.push(1)
    stack.push(2)
    stack.push(9)

    stack.traverse()

    stack.pop()
    stack.pop()
    //stack.pop()
    //stack.pop()

    stack.traverse()
}

fun runLinkedListStack(){
    val stack = LinkedListStack()
    stack.push(1)
    stack.push(2)
    stack.push(9)

    stack.traverse()

    stack.pop()
    stack.pop()
    //stack.pop()
    //stack.pop()

    stack.traverse()
}