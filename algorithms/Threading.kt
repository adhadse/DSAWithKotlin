package src


fun main() {
    Thread(start=true) {
        var count = 0
        do {
            print("Thread created by extending Thread class ${Thread.currentThread().name}")
            count++
        } while (count < 5)
    }

}