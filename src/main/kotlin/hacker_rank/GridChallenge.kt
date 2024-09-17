package org.example.hacker_rank

/*
Given a square grid of characters in the range ascii[a-z],
rearrange elements of each row alphabetically, ascending.
Determine if the columns are also in ascending alphabetical order, top to bottom.
Return YES if they are or NO if they are not.

Example
grid = {"abc", "ade", "efg"}

a b c
a d e
e f g
Answer YES
* */

fun main() {
    val grid = arrayOf("abc", "ade", "efg")
    val grid2 = arrayOf("ebacd", "fghij", "olmkn", "trpqs", "xywuv")
    val grid3 = arrayOf("mpxz", "abcd", "wlmf")
    val grid4 = arrayOf("kc", "iu")
    val grid5 = arrayOf("uxf", "vof", "hmp")
    val grid6 = arrayOf("ppp", "ypp", "wyw")
    val grid7 = arrayOf("lyivr", "jgfew", "uweor", "qxwyr", "uikjd")
    val grid8 = arrayOf("l")
//    println(gridChallenge(grid))
//    println(gridChallenge(grid2))
//    println(gridChallenge(grid3))
//    println(gridChallenge(grid4))
//    println(gridChallenge(grid5))
    println(gridChallenge(grid6))
    println(gridChallenge(grid7))
    println(gridChallenge(grid8))
}

fun gridChallenge(grid: Array<String>): String {
    if (grid.size == 1)
        return "YES"

    var prevL = 'a'
    var prevR = 'a'
    val sortedGrid: MutableList<List<Char>> = mutableListOf()

    //sort each word and then check the first and the last letter
    for (word in grid) {
        val sorted = word.toCharArray().sorted()
        sortedGrid.add(sorted)
        if (sorted[0] >= prevL)
            prevL = sorted[0]
        else
            return "NO"

        if (sorted[sorted.size - 1] >= prevR)
            prevR = sorted[sorted.size - 1]
        else
            return "NO"
    }

    val wordSize = sortedGrid[0].size

    //if there are more than 2 letters in the word, we check other letters vertically in the sorted list of strings(arrays of char)
    if (wordSize > 2) {
        //for each index from the second one to the half of the array
        for (i in 1 .. wordSize / 2) {
            prevL = 'a'
            prevR = 'a'
            //for each word in the list
            for (j in 0 until sortedGrid.size) {
                if (sortedGrid[j][i] >= prevL)
                    prevL = sortedGrid[j][i]
                else
                    return "NO"

                if (sortedGrid[j][wordSize - i] >= prevR)
                    prevR = sortedGrid[j][wordSize - i]
                else
                    return "NO"
            }
        }
    }

    return "YES"
}

fun gridChallenge2(grid: Array<String>): String {
    if (grid.size == 1)
        return "YES"

    var previous = 'a'
    val sortedGrid: MutableList<List<Char>> = mutableListOf()

    for (word in grid) {
        val sorted = word.toCharArray().sorted()
        sortedGrid.add(sorted)
        if (sorted[0] >= previous)
            previous = sorted[0]
        else
            return "NO"
    }

    for (i in 1 until sortedGrid[0].size) {
        previous = 'a'
        for (j in 0 until sortedGrid.size) {
            if (sortedGrid[j][i] >= previous)
                previous = sortedGrid[j][i]
            else
                return "NO"
        }
    }

    return "YES"
}