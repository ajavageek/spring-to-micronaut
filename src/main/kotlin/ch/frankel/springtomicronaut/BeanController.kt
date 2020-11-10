package ch.frankel.springtomicronaut

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.enterprise.inject.spi.Bean
import javax.enterprise.inject.spi.BeanManager

@RestController
class BeanController(private val manager: BeanManager) {

    @GetMapping(path = ["/actuator/beans"])
    fun getAll(): Iterable<Bean<*>> = manager.getBeans(Any::class.java)
}