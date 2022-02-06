private const val THREE = 3

enum class DangerLevel(private val intLevel: Int) {
    HIGH(THREE),
    MEDIUM(2),
    LOW(1);

    fun getLevel() = intLevel
}
