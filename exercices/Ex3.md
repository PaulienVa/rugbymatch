## Let's analyze the game!

We have a team, we have players and we can model set pieces! 
We only need a scoring board to finish our analysis app.

Hint: to help you with this, we already implemented `Score` and `GameScore`. You might want to have a look at it.ª

### Kotlin and Spring boot 2
Check the [application file](./../src/main/kotlin/com/paulienvanalst/rugbymatch/Application.kt) where the Spring boot 2  is set up.
It should not be very different from what is known from Java.

For Spring DI work you need to whether mark injected fields with `lateinit var` (`lateinit` propety could be only `var`, not `val`) or make them `var` with nullable type, and asign to null (e.g. `var someClass: SomeClass? = null`) the former is preffered as allows to keep declaration non-nullable and safely make calls on variable without null-checks (safe calls `?.`).
However, field injection is never recomended and proper way to use DI is to use constructor injection.

Properties annotated 
The only thing is that classes in Spring are final. Spring does not really like that. Therefore the Kotlin class need to be `open`. 
As a developer you have two choices: either make this explicit and declare the Spring annotated class as `open class SomeSpringBean` 
or use the `all-open maven plugin` which will do that work for you.
In this workshop we will choose the explicit option.

The only thing you should know to integrate spring into a Kotlin application, is the `lateinit` modifier. Each property that is initialized through 
dependency injection, should be marked with this modifier. `lateinit` can only be used together with the `var` modifier. Properties annotated 
with those modifiers are not allowed to have custom getters and setters.

### a - Scoring board
In the file [ScoringBoard.kt](./../src/main/kotlin/com/paulienvanalst/rugbymatch/game/ScoringBoard.kt), we will make a class called `ScoringBoard` which is a Spring component.
This scoringboard will have two properties : `hostingTeam` and `visitingTeam` of type `TeamName` who will be initialized once the game is started.
It will also have a list of Scores which is initialized as an empty list.

Now this scoring board should be able to act on several events in the game. In [TimeEvents.kt](./../src/main/kotlin/com/paulienvanalst/rugbymatch/events/TimeEvents.kt) you will find three 
main events that will influence the game board.

Build an event listener using `org.springframework.context.event.EventListener` that will initialize the `hostingTeam` and the `visitingTeam` with the proper team names. 
(This event will be `StartGame`)

Another important event for the ScoringBoard is of course the `ScoringEvent`. 
Build an event listener for this event, that will add a score to the scoring list. (Note you can use the operator `+=` as Kotlin allows operator overloading!)

Last but not least, a method is needed to get the current game score at any time wanted. (interface: `fun currentScore(): GameScore`)

### b - Generate a game report
In file [GameReport.kt](./../src/main/kotlin/com/paulienvanalst/rugbymatch/analytics/GameReport.kt) a lot is already implemented to be able to generate a game report. 
You only need to implement the method `updatingReportAfterSetPiece()` as this is important to analyze the game.
This method should add a set piece to the game report using  the method `addSetPieceEvents()`. This method will update the overall list of set pieces but also 
update the list of scrums and list of lineouts. In order to do this, use `is` of the class check and use `as` to cast.

Now, we should be able to generate a game report at the end of the game. 
From the front-end events are send to the back-end using some REST endpoints, check [GameView.kt](./../src/main/kotlin/com/paulienvanalst/rugbymatch/game/GameView.kt) to check those endpoints.

You will see that only the try scoring endpoint is not implemented yet. You can implement this one, using the same syntax for the `return` statement as the other endpoints.
