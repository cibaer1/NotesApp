package com.cibaer.notesdemo.demo

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
public class NoteController {

    private val testNote = Note("0", "testFileName")
    private val testNote2 = Note("1", "testFileName2")
    private val db = hashMapOf<String, Note?>(
        "0" to testNote,
        "1" to testNote2

    )




    @get:GetMapping("/")
    public val helloString: String = "Hello World"

    @GetMapping("/notes")
    fun showAllNotes(): HashMap<String, Note?> {
        return db
    }

    @GetMapping("/notes/{id}")
    fun getNote(@PathVariable id: String): Note? {
        return db[id]
    }

    @DeleteMapping("/notes/{id}")
    fun deleteNote(@PathVariable id: String): Note? {
        db.remove(id)
        return null
    }

    @PostMapping("/notes")
    fun postNote(@RequestBody @Valid note: Note): Note? {
        var rand = UUID.randomUUID().toString()
        note.id = rand
        db[note.id] = note
        return note

    }
}