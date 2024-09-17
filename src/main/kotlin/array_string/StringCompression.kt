package org.example.array_string

/*
443. String Compression
Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead,
be stored in the input character array chars.
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

Example 1:
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

Example 2:
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.

Example 3:
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
* */
fun main() {
    val chars = charArrayOf('a','a','b','b','c','c','c')
    val chars2 = charArrayOf('a')
    val chars3 = charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b')

    println(compress(chars))
    println(compress(chars2))
    println(compress(chars3))
}

fun compress(chars: CharArray): Int {
    if (chars.isEmpty())
        return 0

    var index = 1
    var numbers = 1

    for (i in 1 until chars.size) {
        if (chars[i - 1] == chars[i]) {
            numbers++
        } else {
            if (numbers > 1) {
                for (dig in numbers.toString()) {
                    chars[index++] = dig
                }
            }
            chars[index++] = chars[i]
            numbers = 1
        }
    }

    if (numbers > 1) {
        for (dig in numbers.toString()) {
            chars[index++] = dig
        }
    }

    return index
}

//This is faster
fun compress2(chars: CharArray): Int {
    val size = chars.size
    var w = 0
    var i = 0
    while (i < size) {
        var j = i
        while (j < size && chars[i] == chars[j]) {
            j++
        }
        chars[w++] = chars[i]
        if (j-i > 1) {
            val str = (j-i).toString()
            for (k in str.indices) {
                chars[w++] = str[k]
            }
        }
        i = j
    }
    return w
}