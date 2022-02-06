private const val HUNDRED = 100

fun tip(bill: Int, percentage: Int = 10): Int {
    return bill * percentage / HUNDRED
}
