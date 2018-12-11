val original = "kenpu"

original.let {
    println("The original String is $it") // "kenpu"
     it.reversed() // reverses the string
}.let {
    println("The reverse String is $it") // "upnek"
    it.length  // changes the type to length
}.let {
    println("The length of the String is $it") // 5
}


original.also {
    println("The original String is $it") // "kenpu"
    it.reversed() // even if we print it, it stays the same
}.also {
    println("The reverse String is ${it}") // "kenpu"
    it.length  // even if we change the type it will not change
}.also {
    println("The length of the String is ${it}") // "kenpu"
}

original.also {
    println("The original String is $it") // "kenpu"
}.also {
    println("The reverse String is ${it.reversed()}") // "upnek", we are not changing the string
}.also {
    println("The length of the String is ${it.length}") /* 5, we do not change the string
    in original we cannot change the value however we can apply functions to them as long as
    we do not try to change the original value*/
}