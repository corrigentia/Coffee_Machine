data class Vehicle constructor(val name: String) {
    // add name

    // create constructor

    // create inner class Body
    inner class Body constructor(val color: String) {
        fun printColor() = println("The ${this@Vehicle.name} vehicle has a $color body.")
    }
}
