package br.com.guia.mock.components

import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.TemporalAdjusters
import java.util.*
import kotlin.random.Random

/*
 * Source Code: https://www.socketloop.com/tutorials/java-human-readable-password-generator
 * Removed K. W. Y, X, Q, H consonants
 */
@Component
class RandomUtilsImpl : RandomUtils {
	private	val   VOWELS      = "aeiou"
	private	val   CONSONANTS  = "bcdfgjlmnprstvz"

	override fun getRandomTimestamp(year: Int, month: Int) : Long {
		val date        = LocalDate.of(year, month, 1)
		val start       = Timestamp.valueOf(date.with(TemporalAdjusters.firstDayOfMonth()).atTime(0, 0, 0)).time
		val end         = Timestamp.valueOf(date.with(TemporalAdjusters.lastDayOfMonth()).atTime(23, 59, 59)).time
		return Random.nextLong(start, end)
	}

	override fun getRandomDate(year: Int, month: Int) : LocalDateTime {
		val date        = LocalDate.of(year, month, 1)
		val start       = Timestamp.valueOf(date.with(TemporalAdjusters.firstDayOfMonth()).atTime(0, 0, 0)).time
		val end         = Timestamp.valueOf(date.with(TemporalAdjusters.lastDayOfMonth()).atTime(23, 59, 59)).time
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(Random.nextLong(start, end)), TimeZone.getDefault().toZoneId())
	}

	override fun getHumanReadableRandomString(min: Int, max: Int): String {
		val size            = Random.nextInt(min, max)
		var random          = 'a'
		var character       = 0
		val word            = StringBuilder(size)

		// If index % 2 != 0 then use vowels else consonants
		for (i in 0 .. size) {
			if (i % 2 == 0) {
				character       = (Math.random() * CONSONANTS.length).toInt()
				random          = CONSONANTS[character]
				word.append(random)
			} else {
				character       = (Math.random() * VOWELS.length).toInt()
				random          = VOWELS[character]
				word.append(random)
			}
		}

		// Always add a vowel at end
		character       = (Math.random() * VOWELS.length).toInt()
		random          = VOWELS[character]
		word.append(random)

		return word.toString()
	}

	override fun getHumanReadableDescription(lenght: Int) : String {
		val word    = StringBuilder(getHumanReadableRandomString(2, 10))

		while (word.length < lenght) {
			word.append(" ")
			word.append(getHumanReadableRandomString(2, 10))
		}

		return word.toString()
	}
}
