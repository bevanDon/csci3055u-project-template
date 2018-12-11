

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



