data class Vehicle constructor(val name: String) {
    // add name

    // create constructor

    inner class Engine constructor(val horsePower: Int) {
        // add horsePower

        // create constructor

        fun start() {
            println("RRRrrrrrrr....")
        }

        // create function printHorsePower()
        fun printHorsePower() = println(
            "The $name vehicle has $horsePower horsepower."
        )
    }
}
