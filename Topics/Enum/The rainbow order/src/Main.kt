enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    companion object {
        fun colorOrder(color: String): Int {
            for (enum in values()) {
                if (color.uppercase() == enum.name) return enum.ordinal + 1
            }
            return -1
        }
    }
}

fun main() {
    val color = readLine()!!
    // put your code here
    println(Rainbow.colorOrder(color))
}
