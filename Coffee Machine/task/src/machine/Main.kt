package machine

import kotlin.math.abs
import kotlin.math.min

const val WATER_INITIALLY = 400
const val MILK_INITIALLY = 540
const val BEANS_INITIALLY = 120
const val DISPOSABLE_CUPS_INITIALLY = 9
const val MONEY_INITIALLY = 550

const val WATER_PER_CUP = 200
const val MILK_PER_CUP = 50
const val BEANS_PER_CUP = 15

const val WRITE_HOW_MANY = "Write how many"

const val ESPRESSO = 1
const val LATTE = 2
const val CAPPUCCINO = 3

const val WATER_FOR_ESPRESSO = 250
const val BEANS_FOR_ESPRESSO = 16
const val ESPRESSO_COST = 4

const val WATER_FOR_LATTE = 350
const val MILK_FOR_LATTE = 75
const val BEANS_FOR_LATTE = 20
const val LATTE_COST = 7

const val WATER_FOR_CAPPUCCINO = 200
const val MILK_FOR_CAPPUCCINO = 100
const val BEANS_FOR_CAPPUCCINO = 12
const val CAPPUCCINO_COST = 6

var mlOfWater = WATER_INITIALLY
var mlOfMilk = MILK_INITIALLY
var gOfCoffeeBeans = BEANS_INITIALLY
var disposableCups = DISPOSABLE_CUPS_INITIALLY
var money = MONEY_INITIALLY

var action = ""

class Emptiness

val empty = Emptiness()
val nothing: Emptiness = Emptiness()

class Patient {
    var name: String = "Unknown"
    var age: Int = 0
    var height: Double = 0.0
}

var patient: Patient = Patient()

val john = Patient()

val alice = Patient()

class Size constructor(width: Int, height: Int) {
    val width: Int = width
    val height: Int = height
    val area: Int = width * height
}

class SizeImmutable constructor(val width: Int, height: Int) {
    val height: Int = height
    val area: Int = width * height
}

class SizeImmutableAbstract constructor(val width: Int, val height: Int) {
    val area: Int = width * height
}

class SizeMutable constructor(var width: Int = 1, var height: Int = 1) {
    val area: Int = width * height
}

class SizeInit constructor(_width: Int, _height: Int) {
    var width: Int = 0
    var height: Int = 0

    init {
        println("Initializer block that prints the width ($_width) and the height ($_height)")
        width = if (_width >= 0) _width else {
            println("Error, the width should be a non-negative value!")
            0
        }
        height = if (_height >= 0) _height else {
            println("Error, the height should be a non-negative value!")
            0
        }
    }
}

class Client {
    val name = "Unknown"
        get() {
            println("Somebody wants to know $field name")
            return field
        }
}

class Entity {
    val name = "Unknown"
        get() = field
}

class Deck {
    val size = 20

    companion object {
        // val defaultSize = size
    }
}

class OuterSingleton {
    class Deep {
        companion object Works {

        }
    }
}

class BadClass {
    companion object {}

    object Named {}

    object Other {

    }
}

object CoffeeMachine {
    var atCoffeeCounter = false

    enum class State(val text: String) {
        CHOOSING_ACTION("choosing an action"), CHOOSING_COFFEE_VARIANT("choosing a variant of coffee");
    }

    var state = State.CHOOSING_ACTION
    fun inputString(input: String) {
    }
}

fun makeCoffee() {
    println(
        """
        Starting to make a coffee
        Grinding coffee beans
        Boiling water
        Mixing boiled water with crushed coffee beans
        Pouring coffee into the cup
        Pouring some milk into the cup
        Coffee is ready!
        """.trimIndent()
    )
}

fun calculateIngredientsNeeded() {
    println("Write how many cups of coffee you will need! ")
    val cupsOfCoffeeNeeded = readLine()!!.toInt()

    val mlOfWater = WATER_PER_CUP * cupsOfCoffeeNeeded
    val mlOfMilk = MILK_PER_CUP * cupsOfCoffeeNeeded
    val gOfCoffeeBeans = BEANS_PER_CUP * cupsOfCoffeeNeeded

    println(
        """
        For $cupsOfCoffeeNeeded cups of coffee, you will need:
        $mlOfWater ml of water,
        $mlOfMilk ml of milk, and
        $gOfCoffeeBeans g of coffee beans.
        """.trimIndent()
    )
}

fun estimateNumberOfServings() {
    val theCoffeeMachineHas = "the coffee machine has! "

    println("$WRITE_HOW_MANY ml of water $theCoffeeMachineHas")
    val mlOfWater = readLine()!!.toInt()

    println("$WRITE_HOW_MANY ml of milk $theCoffeeMachineHas")
    val mlOfMilk = readLine()!!.toInt()

    println("$WRITE_HOW_MANY grams of coffee beans $theCoffeeMachineHas")
    val gOfCoffeeBeans = readLine()!!.toInt()

    println("$WRITE_HOW_MANY cups of coffee you will need! ")
    val cupsOfCoffeeNeeded = readLine()!!.toInt()

    val cupsWithWater = mlOfWater / WATER_PER_CUP
    val cupsWithMilk = mlOfMilk / MILK_PER_CUP
    val cupsWithBeans = gOfCoffeeBeans / BEANS_PER_CUP

    val cupsPossible = min(cupsWithBeans, min(cupsWithWater, cupsWithMilk))

    val differenceBetweenNeedsAndAbilities = abs(cupsOfCoffeeNeeded - cupsPossible)

    println(
        if (cupsPossible == cupsOfCoffeeNeeded) "Yes, I can make that amount of coffee."
        else if (cupsPossible > cupsOfCoffeeNeeded) {
            "Yes, I can make that amount of coffee (and even $differenceBetweenNeedsAndAbilities more than that)."
        } else "No, I can make only $cupsPossible cups of coffee."
    )
}

fun takeAndCollectMoney() {
    println("I gave you $$money.")
    money = 0
}

fun fillAndRenewSupplies() {
    val youWantToAdd = "you want to add? "

    println("$WRITE_HOW_MANY ml of water $youWantToAdd")
    val waterAdded = readLine()!!.toInt()
    mlOfWater += waterAdded

    println("$WRITE_HOW_MANY ml of milk $youWantToAdd")
    val milkAdded = readLine()!!.toInt()
    mlOfMilk += milkAdded

    println("$WRITE_HOW_MANY grams of coffee beans $youWantToAdd")
    val coffeeBeansAdded = readLine()!!.toInt()
    gOfCoffeeBeans += coffeeBeansAdded

    println("$WRITE_HOW_MANY disposable cups of coffee $youWantToAdd")
    val cupsAdded = readLine()!!.toInt()
    disposableCups += cupsAdded
}

fun buyCappuccino() {
    val enoughWater = mlOfWater >= WATER_FOR_CAPPUCCINO
    val enoughMilk = mlOfMilk >= MILK_FOR_CAPPUCCINO
    val enoughBeans = gOfCoffeeBeans >= BEANS_FOR_CAPPUCCINO
    val enoughCups = disposableCups > 0

    if (enoughWater && enoughMilk && enoughBeans && enoughCups) {
        mlOfWater -= WATER_FOR_CAPPUCCINO
        mlOfMilk -= MILK_FOR_CAPPUCCINO
        gOfCoffeeBeans -= BEANS_FOR_CAPPUCCINO
        money += CAPPUCCINO_COST
        --disposableCups
        println("I have enough resources; making you a coffee!")
    } else {
        println(
            "Sorry, not enough ${
                if (!enoughWater) {
                    "water"
                } else {
                    if (!enoughMilk) {
                        "milk"
                    } else {
                        if (!enoughBeans) {
                            "beans"
                        } else "cups"
                    }
                }
            }"
        )
    }
}

fun buyLatte() {
    val enoughWater = mlOfWater >= WATER_FOR_LATTE
    val enoughMilk = mlOfMilk >= MILK_FOR_LATTE
    val enoughBeans = gOfCoffeeBeans >= BEANS_FOR_LATTE
    val enoughCups = disposableCups > 0

    if (enoughWater && enoughMilk && enoughBeans && enoughCups) {
        mlOfWater -= WATER_FOR_LATTE
        mlOfMilk -= MILK_FOR_LATTE
        gOfCoffeeBeans -= BEANS_FOR_LATTE
        money += LATTE_COST
        --disposableCups
    } else {
        println(
            "Sorry, not enough ${
                if (!enoughWater) {
                    "water"
                } else {
                    if (!enoughMilk) {
                        "milk"
                    } else {
                        if (!enoughBeans) {
                            "beans"
                        } else "cups"
                    }
                }
            }"
        )
    }
}

fun buyEspresso() {
    val enoughWater = mlOfWater >= WATER_FOR_ESPRESSO
    val enoughBeans = gOfCoffeeBeans >= BEANS_FOR_ESPRESSO
    val enoughCups = disposableCups > 0

    if (enoughWater && enoughBeans && enoughCups) {
        mlOfWater -= WATER_FOR_ESPRESSO
        gOfCoffeeBeans -= BEANS_FOR_ESPRESSO
        money += ESPRESSO_COST
        --disposableCups
    } else {
        println(
            "Sorry, not enough ${
                if (!enoughWater) "water"
                else if (!enoughBeans) "beans"
                else "cups"
            }"
        )
    }
}

fun buyAndServeTheCoffee() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu? ")
    val option = readLine()!!
    when {
        option == "back" -> return
        option.toInt() == ESPRESSO -> buyEspresso()
        option.toInt() == LATTE -> buyLatte()
        option.toInt() == CAPPUCCINO -> buyCappuccino()
    }
}

fun showRemainingResources() {
    println(
        """
        
        The coffee machine has:
        $mlOfWater of water
        $mlOfMilk of milk
        $gOfCoffeeBeans of coffee beans
        $disposableCups of disposable cups
        $$money of money
        """.trimIndent()
    )
}

fun processQuery() {
    println("Write action (buy, fill, take, remaining, exit)! ")
    action = readLine()!!
    when (action) {
        "buy" -> buyAndServeTheCoffee()
        "fill" -> fillAndRenewSupplies()
        "take" -> takeAndCollectMoney()
        "remaining" -> showRemainingResources()
        "exit" -> return
    }
}

class Passport(number: String) {
    var number = number
        set(value) {
            println("Passport number has changed.")
            field = value
        }
}

class ClientWithPassport {
    val passport = Passport("1234567")
}

val client = ClientWithPassport()
fun main() {
    /*
    val number: Double = 1357.05;
    val number_log: Double = Math.log10(number);
    val number_round: Double = Math.round(number_log).toDouble();
    println(number_round)
    */

    println(patient.name)
    println(patient.age)
    println(patient.height)

    john.name = "John"
    john.age = 30
    john.height = 180.0

    alice.name = "Alice"
    alice.age = 22
    alice.height = 165.0

    println("$john; ${john.name}: ${john.age} yrs, ${john.height} cm")
    println("$alice; ${alice.name}: ${alice.age} yrs, ${alice.height} cm")

    val outer = 10
    if (outer > 0) {
        val inner = 10
        println(inner)
    } else {
        // beyond the if block
        println(outer)
        // println(inner) // Unresolved reference: inner
    }
    // beyond the if-else expression
    println(outer)
    // println(inner) // Unresolved reference: inner

    var id = 5
    if (true) {
        id = 6
        val id = 10
        println(id)
    }
    println(id)

    fun printLine(line: String = "", end: String = "\n") = print("$line$end")

    println(client.passport.number)       // 1234567

    // client.passport = Passport("2345678") // This will not work.

    do {
        processQuery()
    } while (action != "exit")

    // estimateNumberOfServings()
    // calculateIngredientsNeeded()
    // makeCoffee()
}
