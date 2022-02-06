private const val BYTE_MIN_VALUE = -128
private const val BYTE_MAX_VALUE = 127

fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

data class ByteTimer(var time: Int) {
    init {
        time = when {
            time < BYTE_MIN_VALUE -> BYTE_MIN_VALUE
            time > BYTE_MAX_VALUE -> BYTE_MAX_VALUE
            else -> time
        }
    }
}
