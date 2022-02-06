private const val STANDARD_BLOCK_LENGTH = 6
private const val STANDARD_BLOCK_WIDTH = 4

data class Block(val color: String) {
    object BlockProperties {
        var length = STANDARD_BLOCK_LENGTH
        var width = STANDARD_BLOCK_WIDTH

        fun blocksInBox(boxLength: Int = 14, boxWidth: Int = 9) = boxLength / length * (boxWidth / width)
    }
}
