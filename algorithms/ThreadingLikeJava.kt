package src
//
//class Threading: Runnable {
//    override fun run() {
//        var count = 0
//        do {
//            print("Thread created by extending Thread class ${Thread.currentThread().name}")
//            count++
//        } while (count < 5)
//    }
//}

fun main(args: Array<String>) {
//    val thread = Thread(Threading())
    // this can also be done
    val thread = Thread {
        var count = 0
        do {
            print("Thread created by extending Thread class ${Thread.currentThread().name}")
            count++
        } while (count < 5)
    }
    thread.start()
    var count = 0
    do {
        print("Code outside of thread ${Thread.currentThread().name}")
        count++
    } while (count < 5)
}