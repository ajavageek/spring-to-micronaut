package ch.frankel.springtomicronaut

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import io.micronaut.http.MediaType.TEXT_JSON
import io.micronaut.http.annotation.*
import io.micronaut.runtime.Micronaut.build
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Person(@Id val id: Long,
             val firstName: String,
             val lastName: String,
             val birthdate: LocalDate? = null)

@Repository
interface PersonRepository : CrudRepository<Person, Long>

@Controller("/", produces = [TEXT_JSON])
class PersonController(private val repo: PersonRepository) {

    @Get
    fun getAll(): Iterable<Person> = repo.findAll()

    @Get("/{id}")
    fun getOne(@PathVariable id: Long) = repo.findById(id)
}

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("ch.frankel.springtomicronaut")
        .start()
}