enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    companion object {
        fun isRainbow(color: String): Boolean {
            for (enum in values()) {
                if (color.uppercase() == enum.name) return true
            }
            return false
        }
    }
}

fun main() {
    // put your code here
    val color = readLine()!!

    println(Rainbow.isRainbow(color))
}
