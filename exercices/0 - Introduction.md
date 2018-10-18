## Welcome this Kotlin workshop

This workshops consists out of three exercises. Each of them can be done independent from each other and cover different learning goals.
To make sure the exercises can be done independently from one another, the exercises can be found on the branch with the corresponding name.
Those are listened in the table at the end of this introduction.

The project you are going to build is rugby statistic system but you do not need any knowledge whatsoever. You will learn in through the documentation and the tests.

The project uses `Maven`. Often Kotlin is used together with gradle project. This workshop won't take one side or another. 
Since a lot of examples are already covered with `gradle`, it is also interesting to see how to make it work with Maven ;)

The project is set-up with on _java_ directory for the single java class it will ever have and one _kotlin_ directory for the future developments.
During this workshop, you will have to fix the code to make the test pass. Sometimes the code was already set up yo at least compile. But some changes have to be made to make them pass.


Enjoy, learn and embrace Kotlin!


### Workshop set up 

| Exercise | Branch | Topics covered | 
|---|-------|------------------------------------|
| 1 | `Ex1` | `data class` `collections` `types` |
| 2 | `Ex2` |`inheritance` `interfaces` `extension functions` |
| 3 | `Ex3` |`Integration with Spring` |

### Some useful `git` commands
| Command | Description |
|-----------------------------|------------------------------|
| `git checkout {branchName}` | Checkout the branch you need |
| `git stash save {nameOfYourSave}` | Stash your changes and give your save a name |
| `git stash pop {nameOfYourSave}`  | Bring back your changes earlier saved |
| `git commit -m {commitMessage}`   | Commit your code (since you are working on your own fork)|

### Interesting literature: 
- Kotlin Collections versus Java Streams : https://www.baeldung.com/java-8-stream-vs-kotlin
