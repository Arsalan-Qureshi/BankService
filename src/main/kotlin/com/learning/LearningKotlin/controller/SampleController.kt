package com.learning.LearningKotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class SampleController {

    @GetMapping("/greeting")
    fun sampleFunction(): String = "Hello World!"
}