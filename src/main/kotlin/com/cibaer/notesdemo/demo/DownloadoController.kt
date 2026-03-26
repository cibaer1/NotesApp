package com.cibaer.notesdemo.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ContentDisposition
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class DownloadController {
    @Autowired
    lateinit var db: TempDB

    @GetMapping("/notes/{id}/download")
    fun downloadNote(@PathVariable id: String): ResponseEntity<ByteArray> {
        val note = db.db[id] ?:return ResponseEntity.notFound().build()
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_OCTET_STREAM
        headers.contentDisposition = ContentDisposition.attachment().filename(note.fileName).build()
        return ResponseEntity<ByteArray>(note.data, headers, HttpStatus.OK)

    }

}

