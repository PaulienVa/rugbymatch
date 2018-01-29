package com.paulienvanalst.rugbymatch.game

import com.paulienvanalst.rugbymatch.Application
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import  org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = arrayOf(Application::class),
                webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun whenCalled_shouldReturnHello() {
        val result = testRestTemplate
                .getForEntity("/game", String::class.java)

        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body, "Hello Rugby World!")
    }
}