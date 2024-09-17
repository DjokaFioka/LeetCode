package org.example.array_string

import java.util.*

/*
151. Reverse Words in a String
* Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters.
* The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words.
Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
*/

fun main() {
    val s1 = "the sky is blue"
    val s2 = "  hello world  "

    println(reverseWords(s1))
    println(reverseWords(s2))
}

fun reverseWords(s: String): String {
    var sb = StringBuilder()
    val words = Stack<String>()

    for (letter in s) {
        if (letter == ' ') {
            if (sb.isNotEmpty()) {
                words.push(String(sb))
                sb = StringBuilder()
            }
        } else {
            sb.append(letter)
        }
    }

    if (sb.isNotEmpty()) {
        words.push(String(sb))
        sb = StringBuilder()
    }

    while (words.isNotEmpty()) {
        sb.append(words.pop())
        if (words.size > 0)
            sb.append(' ')
    }

    return String(sb)
}


