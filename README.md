## Set up a service with Kotlin and Spring Boot 2 and Junit 5

- _Goal 1_ is very little effort to set up a service with back - and front-end in Kotlin
- _Goal 2_ implement business rules with very little effort


_Warning : Why use experimental incremental version?_



### Lessons learned:
_@SpringBootApplication_ doet een _@ComponentScan_ De package van de klasse waar de annotatie
op gedefinieerd is, is cruciaal. 
Zie: https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-structuring-your-code.html