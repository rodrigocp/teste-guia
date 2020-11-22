package br.com.guia.mock.services

import br.com.guia.mock.components.RandomUtils
import br.com.guia.mock.components.Validation
import br.com.guia.mock.dto.TransactionDTO
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextInt

@Service
class TransactionService(private val validation: Validation, private val random: RandomUtils) {
    @Cacheable("transactions")
    fun findAllTransactions(id: Long, y: Int, m: Int) : List<TransactionDTO> {
        val identifier  = validation.validateIdentifier(id)
        val first       = validation.getFirstDigit(identifier)
        val month       = validation.validateMonth(m)
        val size        = validation.getListSize(first, month)
        return getList(identifier, y, m, size)
    }

    private fun getList(identifier: Int, year: Int, month: Int, size: Int): List<TransactionDTO> {
        return ArrayList<TransactionDTO>().apply {
            for (i in 0 until size) {
                val description = random.getHumanReadableDescription(60)
                val timestamp   = random.getRandomTimestamp(year, month)
                val value       = validation.validateValue((identifier / month) * if (nextBoolean()) { -1 } else { 1 } * i)
                add(TransactionDTO(description, timestamp, value))
            }
        }
    }
}
