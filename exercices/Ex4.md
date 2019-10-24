## 4. *Let*'s *apply* some learnings and enhance the code now *with* some scope functions. (*also* let the players *run*)

Kotlin knows the scope functions, coming from Java those will seem a bit odd and even be very difficult to understand.
But in a bit you might find them very useful! 

Be aware! The differences between the scope functions are very subtle and sometimes hard to remember.

### First some reading to do!

Off course, one can refer to the official documentation:
[here](https://kotlinlang.org/docs/reference/scope-functions.html)

But as stated earlier, they are hard to understand, so there are some very handy blogpost that explain them very well:
- [Blogpost with conventions on when to use them](https://medium.com/@fatihcoskun/kotlin-scoping-functions-apply-vs-with-let-also-run-816e4efb75f5)
- [Blogpost with some extra explanantions](https://medium.com/@elye.project/mastering-kotlin-standard-functions-run-with-let-also-and-apply-9cd334b0ef84)

Both blogpost will give some insights and looks on how to understand the differences and when to use what.


### *Let*'s go and make our hands dirty

A team will undergo a lot of changes during a game. Substitution and injuries will modify it's composition.

The class [TeamManager.kt](./../src/main/kotlin/com/paulienvanalst/rugbymatch/game/TeamManager.kt) will take care of this.

### a - Initialize the teams

Make sure the teams will have the proper names when the game is announced. (Run the tests to validate your solution)

### b - Register the squad announcements

When the squad is announced, the teammanager should make sure the administration is up to date. Make sure using`apply` that the players are 
correctly registered to the squad

### c - Register a substituion into the systems

When a substitution happens, the team manager has to log it and it has to be persisted.

Using `let`, `run` and `also` make sure that:
- the team who does a substitution of players is properly
- the event is logged
- the substitution is saved 

At the end, an event of type [SubstitutionPerformed](./../src/main/kotlin/com/paulienvanalst/rugbymatch/events/TeamManagementEvents.kt) should be broadcast, 
this can be used using `with`.
