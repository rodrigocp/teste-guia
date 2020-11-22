package br.com.guia.mock.controllers

import br.com.guia.mock.services.TransactionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController(private val service: TransactionService) {
    @GetMapping("{id}/transacoes/{ano}/{mes}")
    protected fun find(@PathVariable("id") identifier: Long, @PathVariable("ano") year: Int, @PathVariable("mes") month: Int) : ResponseEntity<Any> {
        return ResponseEntity.ok(service.findAllTransactions(identifier, year, month))
    }
}
