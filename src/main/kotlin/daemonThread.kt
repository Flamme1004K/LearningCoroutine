import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    GlobalScope.launch {
        repeat(1000) {
            i -> println("I'm sleeping $i")
            delay(500L)
        }
    }
    delay(1300L)
    //프로세스가 끝나면 코루틴도 끝난다.
    // runBlocking의 delay가 1300 지날 때 launch도 끝난다.
}