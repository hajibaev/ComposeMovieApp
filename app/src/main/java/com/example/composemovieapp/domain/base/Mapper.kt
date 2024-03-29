package com.example.composemovieapp.domain.base

interface Mapper<From, To> {
    fun map(from: From): To
}