## Set pieces in a game
A rugby game has a lot of set pieces. Those are situations to restart a game. In this workshop you will implement a scrum and a line out.

### a - Interfaces
As a scrum and a line-out are both a set piece, let's start with implementing an interface in [SetPiece.kt](../src/main/kotlin/com/paulienvanalst/rugbymatch/game/SetPieces.kt).
This interface will have two properties : `otherTeam` and `teamThrowingIn` both of type `Team` . And will have one function: `isValid()`

In the same file, make two data classes `Scrum` and `LineOut` implementing the interface `SetPiece`. Make sure they override the properties of the interface

Tip: an interface can be implemented like this `class ClassName() : Interface`

A LineOut is a bit different than a scrum, the throwing in team can choose the number of players participating in the line out. The other team has to follow.
Add two parameters in the line out constructor representing the number of players participating of each team.

Now implement the function `isValid()` for both classes:
* a scrum is valid if each team has a scrum (use the function in `Team`) 
* a line out is valid if each team has the same amount of players

Run the tests for SetPieces.


### b - Inheritance
As we are building an application registering all the events in a rugby game, we will start writing events for the played set pieces.

In the file [GameEvents.kt](../src/main/kotlin/com/paulienvanalst/rugbymatch/events/GameEvents.kt) add a SetPieceEvent class implementing ApplicationEvent from Spring.
This event has a SetPiece and a winning team.

Now as we are playing Scrums and LineOuts, we are making two type of Events:
* ScrumWasPlayed
* LineOutWasPlayed

Both are extending `SetPieceEvent`.

Note a class is by default `final`, so you need to do something to make this happen :)


### c - Extension functions
In the near feature we want to know which set pieces where won by which team. As this statistic is a property of `List<SetPieceEvent>` we will use extenstion functions to implement this.
Extension functions can be implemented like this:
```kotlin
List<SetPiece>.name() : ReturnType = this.something
```

Write two extension functions returning the set pieces won by/lost by a certain team.
The interface being : `winBy(teamName)` and `lostBy(teamName)`.

We also want to have a function returning all the scrum events `scrumEvents()` and one returning all the line out events (`lineOutEvents()`).
Note that you can use `as` to check if a object is of a certain type.

Run the tests for SetPiecesEvent