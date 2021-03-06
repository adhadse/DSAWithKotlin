package ds_Lab

import java.util.Random

class Array(private var no_of_elements: Int) {
    var arr = mutableListOf<Int>(no_of_elements)
    init{
        for (j in 0 until no_of_elements){
            arr.add(Random().nextInt(10))
        }
    }
    fun display(){
        for (j in 0 until no_of_elements){
            print(arr[j])
            print(' ')
        }
        print('\n')
    }
    fun insert(loc:Int,value: Int){
        for(j in (no_of_elements-1) downTo loc){
            arr[j+1] = arr[j]
        }
        arr[loc] = value
    }
    fun delete(loc: Int):Int{
        val Item = arr[loc]
        for (j in loc until no_of_elements){
            arr[j] =arr[j+1]
        }
        return Item
    }

     private fun fib(n:Int):Int{
        if (n<=1)
            return n
        else
            return fib(n-1) + fib(n-2)
    }
    fun fibonacci(elements: Int) {
        if (arr.isNotEmpty()) {
            arr.clear()
        }
        for (j in 2 until elements){
            arr.add(fib(elements))
        }
        return this.display()
    }
}

/**
 *      Array Insertion / Deletion
 */
fun main(){
    val obj= Array(10)
    println("\nOriginal Array Random values")
    obj.display()

    obj.insert(5,value = 5)
    println("\nArray after Insertion")
    obj.display()

    obj.delete(1)
    println("\nArray after deletion")
    obj.display()
}
