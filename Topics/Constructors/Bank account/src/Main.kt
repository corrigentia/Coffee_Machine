// write the BankAccount class here
data class BankAccount constructor(val deposited: Long, val withdrawn: Long) {
    val balance = deposited - withdrawn
}
