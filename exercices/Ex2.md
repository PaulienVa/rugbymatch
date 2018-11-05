## Set pieces in a game
A rugby game has a lot of set pieces. Those are situations to restart a game. In this workshop you will implement a scrum and a line out.

### a - Interfaces
As a scrum and a line-out are both a set piece, let's start with implementing an interface in [SetPieces.kt](../src/main/kotlin/com/paulienvanalst/rugbymatch/game/SetPieces.kt).
This interface will have two properties : `attackingTeam` and `defendingTeam` both of type `Team` . And will have one function: `isValid()`

In the same file, make two data classes `Scrum` and `LineOut` implementing the interface `SetPiece`. Make sure they override the properties of the interface

More information about interfaces can be found [here](https://kotlinlang.org/docs/reference/interfaces.html)

Tip: an interface can be implemented like this `class ClassName() : Interface`

Now implement the function isValid() for both classes:
* a scrum is valid if each team has a scrum (Check the `Team.kt` class, which now has an extra method)
* a line out is valid if each team has the same amount of players

Run the tests for SetPieces. (Do not forget to remove the `@Disabled` annotation.


### b - Inheritance
As we are building an application registering all the events in a rugby game, we will start writing events for the played set pieces.
For this we will be using the `ApplicationEvent` from Spring: an application event has a source (object the object on which the event initially occurred) and all the data related to the event.

In the file [GameEvents.kt](../src/main/kotlin/com/paulienvanalst/rugbymatch/events/GameEvents.kt) add a SetPieceEvent class *implementing ApplicationEvent from Spring*.
Data related to this event is a SetPiece and a winning team.
`SetPieceEvent` is the parent class of the events that will follow later in the exercise. Therefore we will make it a `sealed` class.
For more information check the [Kotlin docs](http://kotlinlang.org/docs/reference/sealed-classes.html)

Now as we are playing Scrums and LineOuts, we are making two type of Events:
* ScrumWasPlayed
* LineOutWasPlayed

Both are extending `SetPieceEvent`.

Note a class is by default `final`, so you need to do something to make this happen :)


### c - Extension functions
In the near feature we want to know which set pieces where won by which team. As this statistic is a property of `List<SetPieceEvent>` we will use extenstion functions to implement this.
Extension functions can be implemented like this:
```kotlin
List<SetPieceEvent>.name() : ReturnType = this.something
```

Write two extension functions returning the set pieces won by/lost by a certain team.
The interface being : `wonBy(teamName)` and `lostBy(teamName)`.

More information about extension functions can be found [here](https://kotlinlang.org/docs/reference/extensions.html)

We also want to have a function returning all the scrum events `scrumEvents()` and one returning all the line out events (`lineOutEvents()`).
Note that you can use `is` to check if a object is of a certain type.

Run the tests for SetPiecesEvent


