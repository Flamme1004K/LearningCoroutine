import kotlinx.coroutines.*

fun main()  = runBlocking {
    this.launch { // launch a new coroutine in background and continue
//         launch -> coroutine builder
//         coroutine scope 안에서 실행 된다.
//        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
//        println("World!") // print after delay
        doWorld()
    }
    println("Hello,") // main thread continues while coroutine is delayed
//    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
//    runBlocking {
//        delay(2000L)
//    }

//    delay(2000L)
}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}