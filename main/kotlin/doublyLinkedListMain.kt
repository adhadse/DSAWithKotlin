package main.kotlin
import dataStructure.DoublyLinkedList

/**
 *  Linked List example
 */
fun main() {
    val input = listOf(1, 2, 3, 4, 5, 6)
    val ll = DoublyLinkedList()

    /**
     *  Insertion
     */
    println("First Insertion in DoublyLinkedList")
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
