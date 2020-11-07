package ch.frankel.springtomicronaut

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Person(@Id val id: Long,
             val firstName: String,
             val lastName: String,
             val birthdate: LocalDate? = null)

interface PersonRepository : CrudRepository<Person, Long>

@RestController("/")
class PersonController(private val repo: PersonRepository) {

    @GetMapping
    fun getAll(): Iterable<Person> = repo.findAll()

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long) = repo.findById(id)
}

@SpringBootApplication
class SpringToMicronautApplication

fun main(args: Array<String>) {
    runApplication<SpringToMicronautApplication>(*args)
}