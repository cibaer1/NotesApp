package com.cibaer.notesdemo.demo

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.validation.constraints.NotEmpty

data class Note(

    var id: String = "0",
    var fileName: String = "",
    @JsonIgnore
    var data: ByteArray = byteArrayOf()
)