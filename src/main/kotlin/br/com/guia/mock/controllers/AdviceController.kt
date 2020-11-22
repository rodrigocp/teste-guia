package br.com.guia.mock.controllers

import br.com.guia.mock.dto.ErrorDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.RuntimeException

@RestControllerAdvice
class AdviceController {
	@ExceptionHandler(RuntimeException::class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	fun handleRuntimeException(exception: RuntimeException?): ErrorDTO {
		return ErrorDTO(exception?.message ?: "")
	}
}
