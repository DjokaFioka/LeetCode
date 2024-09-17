package org.example.array_string

import java.util.*

/*
345. Reverse Vowels of a String
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u',
and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"
* */

fun main() {
    val s1 = "hello"
    val s2 = "leetcode"
    println(reverseVowels(s1))
    println(reverseVowels(s2))
    println(reverseVowels3(s1))
    println(reverseVowels3(s2))
}

fun reverseVowels(s: String): String {
    val arr = s.toCharArray()
    val stack = Stack<Char>()
    for (c in arr) {
        if (isVowel(c))
            stack.push(c)
    }

    for (c in arr.indices) {
        if (isVowel(arr[c])) {
            arr[c] = stack.pop()
        }
    }

    return String(arr)
}

fun reverseVowels2(s: String): String {
    val vowels = LinkedList<Char>()
    val result = StringBuilder()

    for (c in s) {
        if (isVowel(c)) {
            vowels.push(c)
        }
    }

    for (c in s) {
        if (isVowel(c)) {
            result.append(vowels.pop())
        } else {
            result.append(c)
        }
    }

    return result.toString()
}

fun reverseVowels3(s: String): String {
    //Two pointer method
    var left = 0
    var right = s.length - 1
    val arr = s.toCharArray()

    while (left < right) {
        if (!isVowel(arr[left]))
            left++
        if (!isVowel(arr[right]))
            right--

        if (isVowel(arr[left]) && isVowel(arr[right])) {
            val temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp
            left++
            right--
        }
    }

    return String(arr)
}

fun isVowel(c: Char): Boolean {
    return (c == 'a'
            || c == 'e'
            || c == 'i'
            || c == 'o'
            || c == 'u'
            || c == 'A'
            || c == 'E'
            || c == 'I'
            || c == 'O'
            || c == 'U'
            )
}