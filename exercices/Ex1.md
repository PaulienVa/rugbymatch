## 1. Payers in a team

### a - Special feature in IntelliJ

Copy/paste the Java code from the [Player Class](./../src/main/java/com/paulienvanalst/rugbymatch/team/Player.java) into 
the Kotlin file [Player.kt](../src/main/kotlin/com/paulienvanalst/rugbymatch/team/Player.kt)

**Do not copy/paste the `package` and `import` statements.**

You will see an  IntelliJ pop-up, asking you if you want to convert you copied Java code into Kotlin, answer Yes and see what happens.

### b - Refactor into awesome classes

The code that IntelliJ converted is ok-ish, but let's optimize it. The player class is just a simple PoJo for now : it has getters, a `toString()`, `hashCode()` and `equals()` method. 
In Kotlin we can call that a data class. A data class will implicity have getters for the private members, and a `toString()`, `hashCode()`, and `equals()` method. 
Additionally, as we embrace immutability, a data class will also have a `copy()` method

Add the keyword `data` before `class` and remove all the overriden functions.
the `{}` will now gray out, they are useless.

**Congratulations! You just needed one line to create a proper class**

_Or did you ?_ 

Let's check! Open the test `PlayerTest` and remove the `import` statement for the Player class into the Kotlin package and check if the test still runs.

*Note that this test was written in Kotlin and was perfectly working with a Java class*


###  c - Add one method to a data class

A rugby teams is formed by 15 starting players and 7 substitutes. This means that a player can be either starting or a sub.
You can write a `get` function in the Player data class called `isStarting()` using the following syntax:
```kotlin
val isStarting
        get() = 
```
*Note the inRange feature from Kotlin*

Make sure the out-commented tests in `PlayerTest` are running.

###  d - Collections

We now are able to make a team, as we can make players.
In class [Team](../src/main/kotlin/com/paulienvanalst/rugbymatch/team/Team.kt) we will implement some functions to determine if the team is ready to play.
As a team is composed of a list of players, we will check thos conditions using some list manipulations. 

Note that:
 * any collection in Kotlin is already a stream, comparing it to Java you don't need to do any conversion to `Stream<>`
 * the single parameter of a lambda has an implicit name: `it`

Team has to be compliant to the following conditions:
 - _A team has enough players:_ Write a member `hasEnoughPlayers` that verifies that the team has more than 15 players.
 - _A team has enough starting players:_ Write a member `hasEnoughStartingPlayers` that verifies that the team has more than 15 starting players.
 - _A team has any subsitutes_: Write a member `hasAnySubstitutes` that verifies that the team has at least one substitute using `any{}`.


Make sure the tests in the ValidatingTeamTest suite of TeamTest are properly running

### e - Types
Now, we want to find a player that plays the position of scrumhalf, implement a function `scrumhalf` using `find{}`.
Note: It is not sure that a team has a scrumhalf, so this variable can be nullable.
This return type will be `Player?`

Let's assume, we want at all time to know the backnumber of the captain and that this captain is always the scrumhalf.
Implement this function using the null-safe check and implement this using `!!`

As the scrumhalf can also be absent, the replacing captain will be implemented as follows: 
If the scrumhalf is not there, it will be the first other starting player.
Use the Elvis operator `?:` and the null-safety check `?` to implement this function.

Make sure the tests in the CaptainTest suite of TeamTest are properly running


//maybe add internal?