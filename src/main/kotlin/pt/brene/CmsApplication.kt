package pt.brene

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class CmsApplication

fun main(args: Array<String>) {
    SpringApplication.run(CmsApplication::class.java, *args)
}


