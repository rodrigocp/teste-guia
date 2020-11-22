package br.com.guia.mock.components

interface Validation {
    /*
     * ID must be in a range of 1,000 until 100,000
     * @return a valid identifier number
     * @throws exception when value is not in the range
     */
    fun validateIdentifier(value: Long) : Int

    /*
     * Value must be in a range between -9,999,999 and 9,999,999
     * @return a valid value
     */
    fun validateValue(value: Int) : Int

    /*
     * Month between 1 and 12
     * @return passed month
     * @throws exception when month is not in range
     */
    fun validateMonth(value: Int) : Int

    /*
     * Get first digit of integer value
     * @return first digit of value
     */
    fun getFirstDigit(value: Int) : Int

    /*
     * Calculates list size: First Digit * Month
     * @return the calculated list size
     */
    fun getListSize(first: Int, month: Int) : Int
}
