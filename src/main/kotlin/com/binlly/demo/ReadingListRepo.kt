package com.binlly.demo

import org.springframework.data.jpa.repository.JpaRepository

interface ReadingListRepo: JpaRepository<Book, Long> {
    fun findByReader(reader: String): List<Book>?
}