
val t = 25 // can be changed
var y = 5 // cannot be changed

fun bigger_val(c: Int, b: Int): Int { //declaring function
    if (c > b) { // if condition to see the larger value
        return c
    } else {
        return b
    }

}
fun loop(){
    val items  = listOf("jarek", "randy", "ken")
    for (item in items) { // for loop syntax
        println(item)
    }

    val items2 = listOf("jarek", "randy", "ken")
    var index = 0
    while (index < items2.size) {// while loop syntax
        println("item at $index is ${items2[index]}")
        index++
    }
}
fun exp(){
    fun describe(obj: Any): String =
        when (obj) { // uses the when expression
            1          -> "jarek"
            "ken"    -> "3055u"
            is Long    -> "a long val"
            !is String -> "not string"
            else       -> "unsure"
        }

    val fruits = listOf("jarek", "ken pu", "randy", "shapiro")
    fruits
        .filter { it.startsWith("j") } // uses lambda expressions
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}

class Person constructor(firstName: String) {  // creates a basic class

}

fun case_and_switch(){
    var a= 20
    var b = 25
    var max=a
    if (a > b) {
        max = a
    } else {
        max = b
    }

}