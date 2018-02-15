# Welcome to Kotlin! 

Kotlin was developed by IntelliJ and has a lot of awesome features. You will discover some of them
during this workshop. 
For more [Kotlin information](https://kotlinlang.org/docs/reference/)

## First steps into Kotlin
Kotlin loves immutability, in that regard we will aim to respect that feature

#1. (Data) classes
==================

1.1.1 Special feature in IntelliJ
-------------------------------------
Copy/paste the Java code from the [Player Class](./../src/main/java/com/paulienvanalst/rugbymatch/team/Player.java) into 
the Kotlin file [Player.kt](./../src/main/kotlin/com/paulienvanalst/rugbymatch/players/Player.kt)

**Do not copy/paste the `package` and `import` statements.**

You will see an  IntelliJ pop-up, asking you if you want to convert you copied Java code into Kotlin, answer Yes and see what happens.

1.1.2 Refactor into awesome classes
------------------------------------
The code that IntelliJ converted is ok-ish, but let's optimize it. The player class is just a simple PoJo for now. 
In Kotlin we can call that a data class. Add the keyword `data` before `class` and remove all the overriden functions.
the `{}` will now gray out, they are useless.

**Congratulations! You just needed one line to create a proper class**

Or did you ? 

Let's check! Open the test `PlayerTest` and remove the `import` statement for the Player class into the Kotlin package and check if the test still runs.

*Note that this test was written in Kotlin and was perfectly working with a Java class*

1.1.3 Add one method to a data class
------------------------------------
A rugby teams is formed by 15 starting players and 7 substitutes. This means that a player can be either starting or a sub.
You can write a `get` function in the Player data class called `isStarting()` using the following syntax:
```kotlin
val isStarting
        get() = 
```
*Note the inRange feature from Kotlin*

Make sure the out-commented tests in `PlayerTest` are running.

