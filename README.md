# _Kotlin_

> - Bevan Donbosco 100618701
> - bevan.donbosco@uoit.net


## About the language


> - Kotlin is a statically typed programming language that runs on the Java virtual machine. It share similarities to Java but has unique feature implemented to fit a niche similar to scala. It also can be compiled to JavaScript source code or use the LLVM compiler infrastructure. It is a language that can both use OOP and lambda functions  It is created by and endorsed by JetBrains. It primary development team from Jetbrains is from saint Peterburg,Russia

> - Kotlin was first shown in july 2011 by Jetbrains a language for the JVM that had been in development for over a year. Then in 2016 the first version of Kotlin was released, Kotlin V1.0. This was considered the first stable release of Kotlin. It was soon announced that Kotlin would support backwards compatibility and in 2017 google announced they would release support for Kotlin on Android development. 

> - Some interesting features
> - Kotlin features collection featuring, Kotlin has a built in collection system that is comparable to swift.

> - Kotlin has lazy loading features for android development, it is heavily used to reduce app startup time

> - Kotlin is an Open source programming language

> - Kotlin support full Java interoperability. Kotlins runs on JVM and support java libraries and tools
 


## About the syntax



*Look at*

```kotlin
fun printval(val1: String, val2: String) {
    val x = parseInt(val1)
    val y = parseInt(val2)

  
    if (x != null && y != null) {
        
        println(x * y)
    }
    else {
        println("either '$arg1' or '$arg2' is not a number")
    }    
}
```
> - Here we can see code similiar to java with the if/else syntax as well as the println. However we also see slight variations
to the syntax when the function is declared and when variables are declared
## About the tools

> Kotlin design allows for compliation where virtual machines are not needed. It helps resolves the issue where developers need to create a  self-contained program that does not require a virtual machine. Additionally Kotlin supports two-way interoperability this allows Kotlin to  be
> - executable on multiple platforms
> - A framework for apple projects using  C  or swift
> - Use static or dynamic libraries
> - Can be used in projects with multiple different languages


## About the standard library

> Kotlin standard library provides

> - the use of extensions from the JDK which help with file mangement, I/O and threading

> - There are many tools available for data management. We are allowed to create our own datatypes as well as the ability to easily work with strings and char sequences

> - Allows for High-Order functions using patterns such as APPLY, RUN, WHERE, WITH, ALSO etc..

> - Allows for lazy sequences similar to Lisp and extensive function for querying operations

> - Allows for tail recursive functions


```kotlin
     var half_double: Double= Double.MAX_VALUE/2
```
```kotlin
   val eps = 1E-5

tailrec fun  findPoint(x: Double = 1.0): Double
        = if (Math.abs(x - Math.cos(x)) < eps) x else findPoint(Math.cos(x))
```

## About open source library

>_Kotlin poet_
>_https://github.com/square/kotlinpoet_
> -   Kotlin poet is an open source library that cangenerate source files when doing things such as annotation processing or interacting with data files
> - Eliminates writing "template code" in larger projects saving you time
 > a simple example
 ```kotlin
 class Greeter(val name: String) {
  fun greet() {
    println("Hello, $name")
  }
}

fun main(vararg args: String) {
  Greeter(args[0]).greet()
}

 ```
 >can become
 ```kotlin
 val greeterClass = ClassName("", "Greeter")
val file = FileSpec.builder("", "HelloWorld")
    .addType(TypeSpec.classBuilder("Greeter")
        .primaryConstructor(FunSpec.constructorBuilder()
            .addParameter("name", String::class)
            .build())
        .addProperty(PropertySpec.builder("name", String::class)
            .initializer("name")
            .build())
        .addFunction(FunSpec.builder("greet")
            .addStatement("println(%P)", "Hello, \$name")
            .build())
        .build())
    .addFunction(FunSpec.builder("main")
        .addParameter("args", String::class, VARARG)
        .addStatement("%T(args[0]).greet()", greeterClass)
        .build())
    .build()

file.writeTo(System.out)
 ```
> _Kotlin poet also implements a unqiue function KModifier.ABSTRACT to get a function without any body
>With this
```kotlin
val flux = FunSpec.builder("flux")
    .addModifiers(KModifier.ABSTRACT, KModifier.PROTECTED)
    .build()

val helloWorld = TypeSpec.classBuilder("HelloWorld")
    .addModifiers(KModifier.ABSTRACT)
    .addFunction(flux)
    .build()
```
>will result in
```kotlin
abstract class HelloWorld {
    protected abstract fun flux()
}
```
# Analysis of the language

> 1.The style of programming supported by the language: functional vs procedural programming
> - Kotlin supports both procedural programming and functional programming

*An example of functional programming*
```kotlin
fun <T : Comparable<T>> List<T>.quickSort(): List<T> =
    if(size < 2) this
    else {
        val pivot = first()
        val (smaller, greater) = drop(1).partition { it <= pivot}
        smaller.quickSort() + pivot + greater.quickSort()
    }
```
 *example of procedural programming*
 ```kotlin
 for (item in collection) print(item) 
for (i in 1..5) {
    println(i)
}
 ```
2.The ability to perform meta-programming such as macros
> - Kotlin allows the user to modify the language, we are able to create new variable types 

```kotlin
infix fun Double.pwr(exp: Double) = Math.pow(this, exp)
 
fun main(args: Array<String>) {
   val d = 5.0 pwr 10.0
   println(d)
}
```
> - Since Kotlin is using JVM it can use many of the meta programming techniques that are normally in java

3.Symbol resolution and its support for closure
> - Since Kotlin uses JVM we have HARD keywords, these can only be used as keyword and not identifiers
EX.As,Break,class,do etc
> - Soft keywords, act as keyword and can also be used as identifiers
EX.By,Catch,delegate etc
> - Modifier keywords,acts as key words in a modifier list of declarations
EX.Actual,Abstract,const etc
> - Many of kotlins keyword synax is similiar to Java

4.Scoping rules supported by the language: lexical vs dynamic scoping
> - In kotlin we have the ability to use OOP and lambda functions because of this we have a lot of versatility in scoping
Here we are using both the dynamic capabilities of OOP and lambda functions. Also it is important to note that variables labelled as Val cannot be changed once stated. 
```kotlin
fun main(args: Array<String>) {
   var different_scoping = Outer.Nested().scoping()

   print(different_scoping)
   different_scoping = second_scope()
   print(different_scoping)
}
class Outer {
   class Nested {
       fun scoping() = "can be seen"
   }
}

fun second_scope()= "still allowed"
```
```kotlin
Output
can be seen
still allowed
```

Additionally when working with classes we have four different modifiers.
 Public, which is the default modifier that allows any program that create an object to view public items.
 Private which will allow only members inside the class to view. 
Protected same as private however subclass can view as well
Internal any outside class who sees the declaring class sees the internal members
```kotlin
fun lexical() {
   val in_bounds = 5
   run {
       val in_run = 10
       // In_bounds and in_run can be accessed here
   }
   // only in_bounds can be accessed here, in_run is outside the scope
```

5.Functional programming constructs either as part of the language or supported by the standard library of the runtime.
> - Kotlin offers  first class  functional support this is again inspired Java however it was created with support in mind and this resulted better support generally speaking. Additionly, this is better support for refactoring blocs of code.
*We can observe*
```kotlin 
class MyClass {
    fun test() {
        val str: String = "hello"
        val result = str.let  // note we can replace let with run with apply and also
        {
            print(this) 
            print(it) 
          
        }
    }
}

```
note that we are using high order functions

6.Its type system: static vs dynamic types
> Kotlin is a statically type programming language.Therefore it verifys and enforces the constraints type at run time checking to see if all datatypes make sense, this improves run time compared to dynamic typed languages. It is important to note Kotlin does not support static type functions
```kotlin
var changable= 10 // can be changed beacuse of var
var still_changable: Int= Int.MAX_VALUE // creates a new datatype that is changable
val can_not_change=5 // val cannot be changed

```

7.Strengths and weaknesses of the language

PROS
> - Increase efficiency beacuse of it's intuitive it take less time and fewer liner to implement working code
> - Can be compiled with Java
> - Can be used in frameworks in programs with multiple languages
> - It is easily maintainable offering many toolkits to help maintain your code

CONS
> - Does not include namespaces beacuse it keeps functions and values at the top level
> - May seem too similiar to Scala
> - Can not create static type function
> - Since it is a new language there are few experts and online resources for the language
