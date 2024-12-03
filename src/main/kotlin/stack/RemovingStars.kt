package org.example.stack

import java.util.Stack

/*
* 2390. Removing Stars From a String
* You are given a string s, which contains stars *.

In one operation, you can:
Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Example 1:
Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".

Example 2:
Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.
* */

fun main() {
    val s = "leet**cod*e"
    println(removeStarsFromString(s))
    val s2 = "erase*****"
    println(removeStarsFromString(s2))
    println(removeStars(s))
    println(removeStars(s2))
}

fun removeStarsFromString(s: String): String {
    val stack = Stack<Char>()

    for (c in s) {
        if (c == '*')
            stack.pop()
        else
            stack.push(c)
    }

    val result = CharArray(stack.size)
    var index = stack.size - 1

    while (!stack.isEmpty()) {
        result[index] = stack.pop()
        index--
    }

    return String(result)
}

fun removeStars(s: String): String {
    val arr = CharArray(s.length)
    var i = 0
    for(c in s){
        if(c == '*'){
            i--
        }else {
            arr[i] = c
            i++
        }
    }

    val result = StringBuilder()

    for(item in 0..<i){
        result.append(arr[item])
    }

    return result.toString()
}