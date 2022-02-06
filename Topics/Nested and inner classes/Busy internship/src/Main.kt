private const val MIN_WEEK_HOURS = 20
private const val MIN_SALARY = 50
private const val HARD_WORKER_BONUS = 2.8

data class Intern(val weeklyWorkload: Int) {
    val baseWorkload = MIN_WEEK_HOURS

    class Salary {
        val basePay = MIN_SALARY
        val extraHoursPay = HARD_WORKER_BONUS
    }

    val weeklySalary: Double = Salary().basePay + (weeklyWorkload - baseWorkload) * Salary().extraHoursPay
}
