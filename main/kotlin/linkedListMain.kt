package main.kotlin
import dataStructure.LinkedList

/**
 *  Linked List example
 */
fun main() {
    val input = listOf(1, 2, 3, 4, 5, 6)
    val ll = LinkedList()

    /**
     *  Insertion
     */
    println("First Insertion")
    for (Item in input){
        ll.insertAtEnd(data = Item)
        //ll.deleteAtSpecified(1)
    }
    ll.traverse()

    println("\nInsertAtSpecified")
    ll.insertAtSpecified(40,4,true)
    ll.traverse()

    println("\nInsertAtEnd")
    ll.insertAtEnd(10,true)
    ll.traverse()

    /**
     *  Deletion
     */
    println("\nDeletionAtSpecified")
    ll.deleteAtSpecified(5,true)
    ll.traverse()

    println("\nDeletionAtFront")
    ll.deleteAtFront(true)
    ll.traverse()

    println("\nDeleteAtEnd")
    ll.deleteAtEnd(true)
    ll.traverse()

    println("\nDeleteNodesWithValue")
    ll.deleteNodesWithValue(3,true)
    ll.traverse()
}
