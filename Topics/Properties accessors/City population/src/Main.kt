private const val MAX_PEOPLE = 50_000_000

data class City(val name: String) {
    var population: Int = 0
        set(value) {
            field = if (value < 0) {
                0
            } else if (value > MAX_PEOPLE) {
                MAX_PEOPLE
            } else value
        }
}
