package machine

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

var water = WATER_INITIALLY
var milk = MILK_INITIALLY
var beans = BEANS_INITIALLY
var cups = DISPOSABLE_CUPS_INITIALLY
var money = MONEY_INITIALLY

var action = ""


enum class CoffeeVariant(
    val canonicalName: String, val water: Int, val milk: Int, val beans: Int, val price: Int
) {
    ESPRESSO("espresso", WATER_FOR_ESPRESSO, 0, BEANS_FOR_ESPRESSO, ESPRESSO_COST), LATTE(
        "latte", WATER_FOR_LATTE, MILK_FOR_LATTE, BEANS_FOR_LATTE, LATTE_COST
    ),
    CAPPUCCINO(
        "cappuccino", WATER_FOR_CAPPUCCINO, MILK_FOR_CAPPUCCINO, BEANS_FOR_CAPPUCCINO, CAPPUCCINO_COST
    );
}


class CoffeeMachine {
    var water: Int = WATER_INITIALLY
    var milk: Int = MILK_INITIALLY
    var beans: Int = BEANS_INITIALLY
    var cups: Int = DISPOSABLE_CUPS_INITIALLY
    var money: Int = MONEY_INITIALLY

    fun getRemainingResources(): String {
        return """
        
        The coffee machine has:
        $water of water
        $milk of milk
        $beans of coffee beans
        $cups of disposable cups
        $$money of money
        """.trimIndent()
    }

    fun buy(coffeeVariant: CoffeeVariant): String {
        return when {
            water < coffeeVariant.water -> "Sorry, not enough water!"
            milk < coffeeVariant.milk -> "Sorry, not enough milk!"
            beans < coffeeVariant.beans -> "Sorry, not enough coffee beans!"
            cups < 1 -> "Sorry, not enough disposable cups!"
            else -> {
                water -= coffeeVariant.water
                milk -= coffeeVariant.milk
                beans -= coffeeVariant.beans
                --cups
                money += coffeeVariant.price
                return "I have enough resources; making you a coffee!"
            }
        }
    }
}


val coffeeVariantString = CoffeeVariant.values().joinToString { "${it.ordinal + 1} - ${it.canonicalName}" }

val youWantToAdd = "you want to add? "


class CoffeeMachineInterface {
    var atCoffeeCounter = false


    enum class State(val prompt: String) {
        CHOOSING_ACTION("\nWrite action (buy, fill, take, remaining, exit)! "), CHOOSING_COFFEE_VARIANT("What do you want to buy? $coffeeVariantString, back - to main menu: "), ADDING_WATER(
            "$WRITE_HOW_MANY ml of water $youWantToAdd"
        ),
        ADDING_MILK("$WRITE_HOW_MANY ml of milk $youWantToAdd"), ADDING_BEANS("$WRITE_HOW_MANY grams of coffee beans $youWantToAdd"), ADDING_CUPS(
            "$WRITE_HOW_MANY disposable cups of coffee $youWantToAdd"
        ),
        EXIT("");
    }

    var state = State.CHOOSING_ACTION

    fun isRunning() = state != State.EXIT

    fun getPrompt() = state.prompt

    val coffeeMachine = CoffeeMachine()

    fun process(input: String): String {
        when (state) {
            State.CHOOSING_ACTION -> when (input) {
                "buy" -> state = State.CHOOSING_COFFEE_VARIANT
                "fill" -> state = State.ADDING_WATER
                "take" -> {
                    val output = "I gave you $${coffeeMachine.money}"
                    coffeeMachine.money = 0
                    return output
                }
                "remaining" -> return coffeeMachine.getRemainingResources()
                "exit" -> state = State.EXIT
                else -> return "Invalid input!"
            }
            State.CHOOSING_COFFEE_VARIANT -> {
                if (input != "back") coffeeMachine.buy(CoffeeVariant.values()[input.toInt() - 1])
                state = State.CHOOSING_ACTION
            }
            State.ADDING_WATER -> {
                coffeeMachine.water += input.toInt()
                state = State.ADDING_MILK
            }
            State.ADDING_MILK -> {
                coffeeMachine.milk += input.toInt()
                state = State.ADDING_BEANS
            }
            State.ADDING_BEANS -> {
                coffeeMachine.beans += input.toInt()
                state = State.ADDING_CUPS
            }
            State.ADDING_CUPS -> {
                coffeeMachine.cups += input.toInt()
                state = State.CHOOSING_ACTION
            }
            State.EXIT -> return state.prompt
        }
        return ""
    }
}

fun main() {
    val coffeeMachineInterface = CoffeeMachineInterface()
    while (coffeeMachineInterface.isRunning()) {
        println(coffeeMachineInterface.getPrompt())
        val input = readLine()!!
        println(coffeeMachineInterface.process(input))
    }
}
