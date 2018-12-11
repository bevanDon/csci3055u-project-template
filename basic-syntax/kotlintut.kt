

fun main(args: Array<String>) {
    var different_scoping = Outer.Nested().scoping() // different scoping is seen throughout main

    print(different_scoping)
    different_scoping = second_scope()
    print(different_scoping)
}
class Outer {
    class Nested {
        fun scoping() = "can be seen\n" // can be seen in outer
    }
}


fun second_scope()= "still allowed"

fun lexical() {
    val in_bounds = 5
    run {
        val in_run = 10
        // In_bounds and in_run can be accessed here
    }
    // only in_bounds can be accessed here, in_run is outside the scope

}
