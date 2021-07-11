package algorithm

import kotlin.reflect.typeOf

class Sorting<T>(private var arr: MutableList<T> = mutableListOf<T>()) {
    fun bubbleSort(){
        var current = 0
        val last = arr.size - 1
        var swapped = 1
        while (swapped == 1) {
            swapped = 0
            while (current <= (last - 1)) {
                if (arr[current] > arr[current + 1]) {
                    val temp = arr[current]
                    arr[current] = arr[current+1]
                    arr[current+1] = temp
                    swapped = 1
                }
                ++current
            }
            current = 0
        }
    }

    fun selectionSort(){
        var current = 0
        val last = arr.size - 1
        while(current<last) {
            var minIdx = current
            var j = current + 1
            while(j < arr.size) {
                if(arr[minIdx] > arr[j])
                    minIdx = j
                ++j
            }
            val temp = arr[current]
            arr[current] = arr[current+1]
            arr[current+1] = temp
            ++current
        }
    }

    fun insertionSort(){
        var current = 1
        val last = arr.size - 1
        while (current < last){
            val key = arr[current]
//          var lastElem = current -1
            for(lastElem in current-1 downTo 0 ){
                if (key < arr[lastElem]  )
                arr[lastElem + 1] = arr[lastElem]
            }
        }
    }

    fun traverse(){
        for(i in 0 until arr.size){
            print(arr[i])
            print(" ")
        }
        println()
    }
}



class Searching(private val values: List<Int> = listOf<Int>()){
    fun binarySearch(key:Int):Int {
        var lo = 0; var hi = values.size - 1
        while (lo <= hi) {
            val mid = lo + (hi + lo)/2
            when {
                key < values[mid] -> hi = mid - 1
                key > values[mid] -> lo = mid + 1
                else -> return mid
            }
        }
        return -1
    }

    fun linearSearch(key: Int): Int {
        for (value in values) {
            return if (value == key) { value } else -1
        }
        return -1
    }
}
