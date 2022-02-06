private const val FIVE = 5
private const val FOUR = 4

class Car(val make: String, val year: Int) {

    var speed: Int = 0

    // write the methods here
    fun accelerate() {
        this.speed += FIVE
    }

    fun decelerate() {
        this.speed = if (this.speed < FOUR) 0 else this.speed - FIVE
    }
}
