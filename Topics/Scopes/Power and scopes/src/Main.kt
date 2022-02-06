private const val TEN = 10
private const val THIRTEEN_INT = 13
private const val THIRTEEN_LONG = 13L

fun main() {
    // change the code below
    var thirteen = THIRTEEN_LONG

    for (i in 2..TEN) {
        thirteen *= THIRTEEN_INT
        println(thirteen)
    }
}
