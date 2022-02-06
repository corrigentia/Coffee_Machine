private const val THREE = 3

data class Player(val id: Int, val name: String) {
    companion object {
        private const val defaultSpeed = 8
        const val maxSpeed = 13

        fun calcMovePenalty(cell: Int): Int {
            return defaultSpeed - cell % THREE
        }
    }
}

fun calculatePlayerSpeed(cell: Int): Int {
    return Player.calcMovePenalty(cell)
}
