private const val SEVEN = 7
private const val FIVE = 5

// write the IceCreamOrder class here
class IceCreamOrder {
    val price: Int

    constructor(popsicles: Int) {
        this.price = SEVEN * popsicles
    }

    constructor(scoops: Int, toppings: Int) {
        this.price = FIVE * scoops + 2 * toppings
    }
}
