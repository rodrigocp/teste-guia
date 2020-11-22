package br.com.guia.mock.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
data class TransactionDTO (
    @JsonProperty("descricao")
    var description : String,

    @JsonProperty("data")
    var date	    : Long,

    @JsonProperty("valor")
    var value	    : Int
)
