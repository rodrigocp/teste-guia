package br.com.guia.mock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class MockApplication

fun main(args: Array<String>) {
	runApplication<MockApplication>(*args)
}
