## Let's analyze the game!

We have a team, we have players and we can model set pieces! 
We only need a scoring board to finish our analysis app.

Most of the exercises can be verified using Spring integration tests, but if you want to test it using some interface, 
that is also possible. You only need to do an `ng serve` in the `analytics-app` directory to run the app on `localhost:4200`. 

### Kotlin and Spring boot 2
Check the [application file](./../src/main/kotlin/com/paulienvanalst/rugbymatch/Application.kt) where the Spring boot 2  is set up.
It should not be very different from what is known from Java.

The only think you should know to integrate spring into a Kotlin application, is the `lateinit` modifier. Each property that is initialized through 
dependency injection, should be marked with this modifier. `lateinit` kan only be used together with the `var` modifier. Properties annotated 
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
