package algorithms

class Algorithm{
    private val values = listOf<Int>()
    
    fun binarySearch(key:Int):Int {
        var lo = 0; var hi = values.size - 1
        while (lo <= hi){
            val mid = lo + (hi + lo)/2
            when {
                key < values[mid] -> hi = mid - 1
                key > values[mid] -> lo = mid + 1
                else -> return mid
            }
        }
        return -1
    }
}