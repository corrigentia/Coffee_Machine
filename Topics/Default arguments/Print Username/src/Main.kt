fun greetHacker(name: String = "secret user") = println(
    "Hello, ${if (name == "HIDDEN") "secret user" else name}!"
)

fun main() {
    // write your code here
    greetHacker(readLine()!!)
}
