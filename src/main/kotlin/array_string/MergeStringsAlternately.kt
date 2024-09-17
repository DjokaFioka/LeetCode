package org.example.array_string

/*
1768.
You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order, starting with word1.
If a string is longer than the other, append the additional letters onto the end of the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
* */
fun main(){
    val word1 = "abcd"
    val word2 = "pq"

    println(mergeAlternately(word1, word2))
}

fun mergeAlternately(word1: String, word2: String): String {
    if (word1.isEmpty())
        return word2
    if (word2.isEmpty())
        return word1

    val maxLength = maxOf(word1.length, word2.length)
    val sb = StringBuilder()

    for (i in 0 until maxLength) {
        if (i < word1.length)
            sb.append(word1[i])
        if (i < word2.length)
            sb.append(word2[i])
    }

    return String(sb)
}

fun mergeAlternatelyBySomeone(word1: String, word2: String): String {
    //it's faster by 9ms
    val sb = StringBuilder()
    val n = minOf(word1.length, word2.length)

    for (i in 0 until n) {
        sb.append(word1[i])
        sb.append(word2[i])
    }

    sb.append(word1.substring(n))
    sb.append(word2.substring(n))

    return sb.toString()
}
