# _Kotlin_

> Bevan Donbosco 100618701
> bevan.donbosco@uoit.net


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


