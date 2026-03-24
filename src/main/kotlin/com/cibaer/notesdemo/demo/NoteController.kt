package com.cibaer.notesdemo.demo

import jakarta.validation.Valid
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
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

    @GetMapping("/notes/{id}/content", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun getNoteContent(@PathVariable id: String): ResponseEntity<ByteArray> {
        val note = db[id] ?:return ResponseEntity.notFound().build()
        val headers = HttpHeaders()
        headers.contentType = MediaType.TEXT_PLAIN
        return ResponseEntity(note.data, headers, HttpStatus.OK)

    }

    @PostMapping("/notes", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun postNote(@RequestPart("data") file: MultipartFile): Note? {
        var note = Note(
            id = UUID.randomUUID().toString(),
            fileName = file.originalFilename ?: "unknown",
            data = file.bytes
        )
        db[note.id] = note
        return note
    }
}