package com.github.bolkunets.alexandr.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HelloWorldApplication

fun main(args: Array<String>) {
    runApplication<HelloWorldApplication>(*args)
}

@RestController
class Greeter {
    @GetMapping
    fun hello(@RequestParam(required = false) name: String?) = """{ "message": "hello world${if (name.isNullOrEmpty()) "" else ", $name"}!!!"  }"""
}