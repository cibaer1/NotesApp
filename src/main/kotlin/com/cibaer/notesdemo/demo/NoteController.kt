package com.cibaer.notesdemo.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
public class NoteController {

    @get:GetMapping("/")
    public val helloString: String = "Hello World"
}