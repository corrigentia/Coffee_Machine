private const val INITIAL_PRICE = 20_000
private const val ANNUAL_DEPRECIATION = 2_000
private const val STANDARD_MAX_SPEED = 120
private const val SPEED_PENALTY = 100
private const val MILEAGE_DEPRECIATION = 200
private const val MILEAGE_STEP = 10_000
private const val TRANSMISSION_BONUS = 1_500

// complete this function, add default values
fun carPrice(
    old: Int = 5,
    kilometers: Int = 100_000,
    maximumSpeed: Int = STANDARD_MAX_SPEED,
    automatic: Boolean = false
) {
    val agePenalty = ANNUAL_DEPRECIATION * old

    val speedDisadvantage = STANDARD_MAX_SPEED - maximumSpeed
    val speedPenalty = SPEED_PENALTY * speedDisadvantage

    val usedOver = kilometers / MILEAGE_STEP
    val mileagePenalty = MILEAGE_DEPRECIATION * usedOver

    val transmissionBonus = if (automatic) TRANSMISSION_BONUS else 0

    println(INITIAL_PRICE - agePenalty - speedPenalty - mileagePenalty + transmissionBonus)
}
