import kotlinx.coroutines.*

fun main() = runBlocking{
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) { // computation loop, just wastes CPU
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                //delay(1L)
                yield()
                // 코루틴을 취소시키려면 suspend 함수가 있어야 한다.
                // 이중 yield는 exception을 실행 시켜 중단시킨다.
                // 즉 코루틴이 취소되기위해서는 협조적이어야 한다.
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}