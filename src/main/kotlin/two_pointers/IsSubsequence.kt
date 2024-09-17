package org.example.two_pointers

/*
392. Is Subsequence
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
* */

fun main() {
    val s = "abc"
    val t = "ahbgdc"
    val s2 = "axc"
    val t2 = "ahbgdc"
    println(isSubsequence(s, t))
    println(isSubsequence(s2, t2))
}

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty())
        return true
    if (s == t)
        return true
    if (t.isEmpty())
        return false

    var indexS = 0

    for (c in t) {
        if (c == s[indexS]) {
            indexS++
        }
        if (indexS >= s.length)
            return true
    }

    return false
}