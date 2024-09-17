package org.example.array_string

/*
1071. Greatest Common Divisor of Strings
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
* */
fun main() {
//    val str1 = "ABCABC"
//    val str2 = "ABC"
//    val str1 = "ABABAB"
//    val str2 = "ABAB"
    val str1 = "LEET"
    val str2 = "CODE"

    println(gcdOfStrings(str1, str2))
}

fun gcdOfStrings(str1: String, str2: String): String {
    // Check if gcd exists
    if (str1 + str2 != str2 + str1) {
        return ""
    }

    // Count gcd of string lengths
    var l1 = str1.length
    var l2 = str2.length
    while (l1 != l2) {
        if (l1 > l2)
            l1 -= l2
        else
            l2 -= l1
    }

    return str1.substring(0, l1)
}