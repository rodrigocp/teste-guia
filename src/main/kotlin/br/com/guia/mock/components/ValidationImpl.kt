package br.com.guia.mock.components

import org.springframework.stereotype.Component
import java.lang.RuntimeException
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

@Component
class ValidationImpl : Validation {
    override fun validateIdentifier(value: Long) : Int {
        if (value in 1_000 .. 100_000) {
            return value.toInt()
        } else {
            throw RuntimeException("Invalid identifier!")
        }
    }

    override fun validateValue(value: Int): Int {
        var cost    = value

        while (cost < -9_999_999 || cost > 9_999_999) {
            cost /= 10
        }

        return cost
    }

    override fun validateMonth(value: Int) : Int {
        if (value in 1 .. 12) {
            return value
        } else {
            throw RuntimeException("Invalid month!")
        }
    }

    override fun getFirstDigit(value: Int) : Int {
        return if (value == 0) {
            0
        } else {
            floor(abs(value) / 10.0.pow(floor(log10(abs(value).toDouble())))).toInt()
        }
    }

    override fun getListSize(first: Int, month: Int) : Int {
        return first * month
    }
}
