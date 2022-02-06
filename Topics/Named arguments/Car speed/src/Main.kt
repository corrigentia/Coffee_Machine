private const val DEFAULT_SPEED_LIMIT = 60

fun main(args: Array<String>) {
    // write your code here
    val actualSpeed = readLine()!!.toInt()
    val speedLimit = readLine()!!

    carSpeed(speed = actualSpeed, limit = speedLimit)
}

fun carSpeed(speed: Int, limit: String = DEFAULT_SPEED_LIMIT.toString()) {
    val speedExcess = speed - if (limit == "no limit") DEFAULT_SPEED_LIMIT else limit.toInt()

    println(
        if (speedExcess < 1) {
            "Within the limit"
        } else "Exceeds the limit by $speedExcess kilometers per hour"
    )
}
