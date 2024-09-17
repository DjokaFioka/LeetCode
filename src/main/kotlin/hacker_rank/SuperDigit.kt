package org.example.hacker_rank

/*
HackerRank
We define super digit of an integer x using the following rules:
Given an integer, we need to find the super digit of the integer.

If x has only 1 digit, then its super digit is x.
Otherwise, the super digit of x is equal to the super digit of the sum of the digits of x.
For example, the super digit of 9875 will be calculated as:
super_digit(9875) => 9+8+7+5 = 29
super_digit(29) => 2+9 = 11
super_digit(11) => 1+1 = 2
super_digit(2) => 2

Example:
n = 9875
k = 4
The number p is created by concatenating the string n k times so the initial
p = 9875987598759875
super_digit(p) => 9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
super_digit(p) => 1+1+6 = 8
super_digit(p) => 8

*/

fun main(){
    val digit1 = "9875"
    val repeat1 = 4
    //Bice -> "9875987598759875"

    val digit3 = "148"
    val repeat3 = 3
    //Bice -> "148148148"

    println(superDigit(digit1, repeat1))
    println(superDigit(digit3, repeat3))
}

fun superDigit(n: String, k: Int): Int {
    if (n.isEmpty())
        return 0

    if (n.length == 1)
        return n.toInt()

    val list: List<Long> = n.map {
        it.digitToInt().toLong()
    }

    val total = (list.sum() * k).toString()

    return superDigit(total, 1)
}