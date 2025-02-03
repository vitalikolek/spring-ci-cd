package com.example.spring_ci_cd

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SpringCiCdApplication

fun main(args: Array<String>) {
	runApplication<SpringCiCdApplication>(*args)
}

@Entity
@Table(name = "book")
class Book {
	@Id
	var id: UUID? = null
	var title: String = ""
	var author: String = ""
}

data class BookRequest(
	val id: UUID? = null,
	val title: String,
	val author: String,
)

interface BookRepository : JpaRepository<Book, UUID>

@Service
class BookService(val bookRepository: BookRepository) {

	fun findAll(): List<Book> = bookRepository.findAll()
	fun findBookById(bookId: UUID): Book? = bookRepository.findByIdOrNull(bookId)
	fun createBook(request: BookRequest): Book {
		return Book().apply {
			id = UUID.randomUUID()
			title = request.title
			author = request.author
			bookRepository.save(this)
		}
	}
}

@RestController
class DemoController {

	@GetMapping("/")
	fun demo() = "Hello, Render!!!"
}