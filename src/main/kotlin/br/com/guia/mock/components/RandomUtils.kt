package br.com.guia.mock.components

import java.time.LocalDateTime

interface RandomUtils {
	/*
	 * Random Timestamp is calculated by getting first day of month minus last day of month.
	 * Then a random function is applied.
	 *
	 * @return random timestamp based on month and year
	 */
	fun getRandomTimestamp(year: Int, month: Int) : Long

	/*
	 * Random Timestamp is calculated by getting first day of month minus last day of month.
	 * Then a random function is applied.
	 * Then result is transformed to LocalDateTime
	 * @return random timestamp based on month and year
	 */
	fun getRandomDate(year: Int, month: Int) : LocalDateTime

	/*
	 * Generate a "readable" random string
	 * @return a "readable" string
	 */
	fun getHumanReadableRandomString(min: Int, max: Int): String

	/*
	 * Generate a collection of "readable" string (aka description)
	 * @return a "readable" description
	 */
	fun getHumanReadableDescription(lenght: Int) : String
}
