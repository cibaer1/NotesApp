package com.cibaer.notesdemo.demo

public class Note {

    public var id: String = ""


    constructor(id: String, fileName: String) {
        this.id = id
        this.fileName = fileName
    }

    public var fileName: String = ""
}