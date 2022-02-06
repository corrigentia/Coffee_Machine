import kotlin.math.pow

private const val HUNDRED = 100.0

fun main() {
    // write your code here
    val parameter = readLine()!!
    val value = readLine()!!.toInt()
    when (parameter) {
        "amount" -> finalAmount(amount = value)
        "percent" -> finalAmount(percent = value)
        "years" -> finalAmount(years = value)
    }
}

fun finalAmount(amount: Int = 1000, percent: Int = 5, years: Int = 10) {
    println(
        (amount * (1 + percent / HUNDRED).pow(years)).toInt()
    )
}
