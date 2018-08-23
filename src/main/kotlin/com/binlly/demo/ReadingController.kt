package com.binlly.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

private const val reader = "yy"

@Controller
@RequestMapping("/readings")
class ReadingController @Autowired constructor(private val repo: ReadingListRepo) {

    @RequestMapping(method = [RequestMethod.GET])
    fun readerBooks(model: Model): String {
        val books = repo.findByReader(reader)
        books?.let {
            model.addAttribute("books", books)
        }
        return "readings"
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun addToReadingList(book: Book, result: BindingResult): String {
        book.reader = reader
        repo.save(book)
        return "redirect:/readings"
    }
}