enum class Country(val currency: String) {
    GERMANY("Euro"),
    SPAIN("Euro"),
    FRANCE("Euro"),
    AUSTRALIA("Australian dollar"),
    KIRIBATI("Australian dollar"),
    DOMINICA("Eastern Caribbean dollar"),
    GRENADA("Eastern Caribbean dollar"),
    MALI("CFA franc"),
    SENEGAL("CFA franc"),
    CANADA("Canadian dollar"),
    BRAZIL("Brazilian real"),
    NULL("");

    companion object {
        private fun isCountry(country: String): Boolean {
            for (enum in values()) {
                if (country.uppercase() == enum.name) return true
            }
            return false
        }

        private fun findCountryCurrency(country: String): String {
            return if (isCountry(country)) return valueOf(country.uppercase()).currency else NULL.currency
        }

        fun sameCurrency(country1: String, country2: String): Boolean {
            return isCountry(country1) && isCountry(country2) && findCountryCurrency(country1) == findCountryCurrency(
                country2
            )
        }
    }
}

fun main() {
    // put your code here
    val (country1, country2) = readLine()!!.split(' ')

    println(Country.sameCurrency(country1, country2))
}
