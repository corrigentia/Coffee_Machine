private const val COLDEST_CUTOFF = -92
private const val HOTTEST_CUTOFF = 57

private const val DUBAI_AVERAGE_TEMPERATURE = 30
private const val HANOI_AVERAGE_TEMPERATURE = 20
private const val MOSCOW_AVERAGE_TEMPERATURE = 5

data class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value < COLDEST_CUTOFF || value > HOTTEST_CUTOFF) {
                when (name) {
                    "Dubai" -> DUBAI_AVERAGE_TEMPERATURE
                    "Hanoi" -> HANOI_AVERAGE_TEMPERATURE
                    "Moscow" -> MOSCOW_AVERAGE_TEMPERATURE
                    else -> 0
                }
            } else value
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    // implement comparing here
    val t1 = firstCity.degrees
    val t2 = secondCity.degrees
    val t3 = thirdCity.degrees
    print(
        if (t1 < t2 && t1 < t3) {
            firstCity.name
        } else if (t2 < t3 && t2 < t1) {
            secondCity.name
        } else if (t3 < t1 && t3 < t2) {
            thirdCity.name
        } else "neither"
    )
}
