package ch.frankel.springtomicronaut

import io.quarkus.runtime.Quarkus
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*
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
    fun getOne(@PathVariable("id") id: Long): Optional<Person> = repo.findById(id)
}

fun main(args: Array<String>) {
    Quarkus.run(*args)
}