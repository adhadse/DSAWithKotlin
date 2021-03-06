package main.kotlin
import dataStructure.CircularLinkedList

/**
 *  Linked List example
 */
fun main() {
    val input = listOf(1, 2, 3, 4, 5, 6)
    val ll = CircularLinkedList()

    /**
     *  Insertion
     */
    println("First Insertion in Circular linked list")
    for (Item in input) {
        ll.insertAtEnd(data = Item)
        //ll.deleteAtSpecified(1)
    }
    ll.traverse()

    println("Insertion at Front")
    ll.insertAtFront(data = 99)
    ll.traverse()

    println("Insertion at end")
    ll.insertAtEnd(data = 44)

    /**
     *  Deletion
     */
    println("Deletion at Front")
    ll.deleteAtFront()
    ll.traverse()

    println("Deletion at end")
    ll.deleteAtLast()
    ll.traverse()
}


