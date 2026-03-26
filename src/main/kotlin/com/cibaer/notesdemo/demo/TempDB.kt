package com.cibaer.notesdemo.demo

import org.springframework.stereotype.Component

@Component
class TempDB {

    private val testNote = Note("0", "testFileName")
    private val testNote2 = Note("1", "testFileName2")
    public val db = hashMapOf<String, Note?>(
        "0" to testNote,
        "1" to testNote2

    )
}