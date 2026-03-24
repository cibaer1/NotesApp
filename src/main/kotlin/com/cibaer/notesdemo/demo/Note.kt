package com.cibaer.notesdemo.demo

import jakarta.validation.constraints.NotEmpty

data class Note(
    var id: String = "0",
    var fileName: String = "default"
)