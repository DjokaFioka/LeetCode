package org.example.sliding_window

/*
1456. Maximum Number of Vowels in a Substring of Given Length
Given a string s and an integer k, return the maximum number of vowel letters
in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
* */

fun main() {
    val s1 = "abciiidef"
    val k1 = 3

    val s2 = "aeiou"
    val k2 = 2

    val s3 = "leetcode"
    val k3 = 3

    val s4 = "tryhard"
    val k4 = 4

    println(maxVowels(s1, k1))
    println(maxVowels(s2, k2))
    println(maxVowels(s3, k3))
    println(maxVowels(s4, k4))
}

fun maxVowels(s: String, k: Int): Int {
    var result = 0
    var sum: Int

    for (c in s.subSequence(0, k)) {
        if (isVowel(c))
            result++
    }

    sum = result

    for (c in k until s.length) {
        if (isVowel(s[c - k]))
            result--
        if (isVowel(s[c]))
            result++

        sum = maxOf(sum, result)
    }

    return sum
}

fun isVowel(c: Char): Boolean {
    return (c == 'a' || c == 'e' || c == 'i' ||c == 'o' || c == 'u')
}