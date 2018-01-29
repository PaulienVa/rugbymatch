package com.paulienvanalst.rugbymatch.game

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController {

    @GetMapping("/")
    fun home(): String {
        return "Welcome to this awesome workshop!"
    }

    @GetMapping("/game")
    fun play(): String {
        return "Hello Rugby World!"
    }
}