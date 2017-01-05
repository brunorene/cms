package pt.brene.controller

import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@RestController
class PersonController(val repository: PersonRepository) {

    @GetMapping("/")
    fun findAll(): Iterable<Person> = repository.findAll()

    @GetMapping("/{name}")
    fun findByLastName(@PathVariable name: String) = repository.findByLastName(name)

    @PostMapping
    fun save(@RequestBody person: Person): Person = repository.save(person)
}

@Entity
class Person(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var firstName: String = "",
        var lastName: String = ""
)

interface PersonRepository : CrudRepository<Person, Long> {
    fun findByLastName(name: String): List<Person>
}