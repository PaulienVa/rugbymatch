## 1. Payers in a team

### a - Special feature in IntelliJ
**IMPORTANT: In the following exercise do not copy/paste the `package` and `import` statements.**

Copy the code describing the class [Player.java](./../src/main/java/com/paulienvanalst/rugbymatch/team/Player.java) and
paste it to __replace__ the class declaration in the Kotlin file [Player.kt](../src/main/kotlin/com/paulienvanalst/rugbymatch/team/Player.kt)

You will see an  IntelliJ pop-up, asking you if you want to convert you copied Java code into Kotlin, answer Yes and see what happens.

### b - Refactor into awesome classes

The code that IntelliJ converted is ok-ish. It compiles and it looks like Kotlin. But it still Kotlin code that is equivalent to Java code. Let's now make it some proper Kotlin code.

The player class is just a simple PoJo for now : a part fro the `isStarting` function, it has getters, a `toString()`, `hashCode()` and `equals()` method. 
In Kotlin we can call that a data class. A data class will implicitly have getters for the members as they are public by default. It wil also have a `toString()`, `hashCode()`, and `equals()` method. 
Additionally, as we embrace immutability, a data class will also have a `copy()` method.

Add the keyword `data` before `class` and remove all the overriden functions. But leave the `isStarting` function.

**Congratulations! You just needed two lines to create a proper class**

_Or did you ?_ 

Let's check! Open the test `PlayerTest` and remove the `import` statement for the Player class into the Kotlin package.
Now enable the first test suite `PlayerClassTest` by removing the `@Disable` annotation. Run this suite to check if the conversion was successful.

*Note that this test was written in Kotlin and was perfectly working with a Java class*

###  c - Add one method to a data class
A rugby teams is formed by 15 starting players and 7 substitutes. This means that a player can be either starting or a sub.
 You can write a get function in the Player data class called isStarting() using the following syntax:
```kotlin
val isStarting
        get() = 
```
*Note the inRange feature from Kotlin. See for more info [here](https://kotlinlang.org/docs/reference/ranges.html)*

Make sure the tests in suite `PlayerIsStartingTest` in `PlayerTest` are running (do not forget to remove the `@Disabled` annotation).

###  d - Collections

We now are able to make a team, as we can make players.
In class [Team](../src/main/kotlin/com/paulienvanalst/rugbymatch/team/Team.kt) we will implement some functions to determine if the team is ready to play.
As a team is composed of a list of players, we will check those conditions using some collection manipulations. 

Note that:
 * any collection in Kotlin is supports the same methods as the Java `Stream`. Comparing it to Java you don't need to do any conversion to `Stream<>`
 * A lambda expression can be written into brackets `{}`.
 * the single parameter of a lambda has an implicit name: `it`.
 
 An example illustrating those points could be:  Given a collection named `examples`, a valid collection manipulation could be: 
 
 `examples.filter { it.forExercise1() }`
 
Team has to be compliant to the following conditions:
 - _A team has enough players:_ Write a member `hasEnoughPlayers` that verifies that the team has more than 15 players.
 - _A team has enough starting players:_ Write a member `hasEnoughStartingPlayers` that verifies that the team has more than 15 starting players.
 - _A team has any subsitutes_: Write a member `hasAnySubstitutes` that verifies that the team has at least one substitute using `.any{}`.


Make sure the tests in the `ValidatingTeamTest` suite of `TeamTest` are properly running (do not forget to remove the `@Disabled` annotation).

### e - Types
This exercise is about null-safety. For more information, please refer to the documentation [here](https://kotlinlang.org/docs/reference/null-safety.html)

Now, we want to find a player that plays the position of scrumhalf, implement a function `scrumhalf` using `find{}`.
Note: It is not sure that a team has a scrumhalf, so this variable can be nullable. 
As it can be nullable, its return type will be `Player?`.

Let's assume, we want at all time to know the backnumber of the captain and that this captain is always the scrumhalf.
Implement this function using the null-safe check and implement this using `!!`.

As the scrumhalf can also be absent, the replacing captain will be implemented as follows: 
If the scrumhalf is not there, it will be the first other starting player.
Use the Elvis operator `?:` and the null-safety check `?` to implement this function.

Make sure the tests in the `CaptainTest` suite of `TeamTest` are properly running (do not forget to remove the `@Disabled` annotation).
