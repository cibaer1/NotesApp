package com.cibaer.notesdemo.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotesDemoApplication

fun main(args: Array<String>) {
	runApplication<NotesDemoApplication>(*args)
}
