package com.cibaer.notesdemo.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
public class NoteController {

    private val testNote = Note("0", "testFileName")
    private val testNote2 = Note("1", "testFileName2")
    private val notesMap = hashMapOf<Int, Note?>(
        0 to testNote,
        1 to testNote2

    )




    @get:GetMapping("/")
    public val helloString: String = "Hello World"

    @GetMapping("/notes")
    fun showAllNotes(): HashMap<Int, Note?> {
        return notesMap
    }

    @GetMapping("/notes/{id}")
    fun getNote(@PathVariable id: Int): Note? {
        return notesMap[id]
    }
}