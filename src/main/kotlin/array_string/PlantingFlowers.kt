package org.example.array_string

/*
605. Can Place Flowers
* You have a long flowerbed in which some of the plots are planted,
* and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's,
* where 0 means empty and 1 means not empty, and an integer n,
* return true if n new flowers can be planted in the flowerbed
* without violating the no-adjacent-flowers rule and false otherwise.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 * */

fun main() {
//    val flowerbed = intArrayOf(1,0,0,0,1)
//    val n = 1

//    val flowerbed = intArrayOf(1,0,0,0,0,1)
//    val n = 2

//    val flowerbed = intArrayOf(1,0,0,0,1,0,0)
//    val n = 2

    val flowerbed = intArrayOf(0)
    val n = 1

    println(canPlaceFlowers(flowerbed, n))
}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    if (n == 0)
        return true
    var result = n
    for (i in flowerbed.indices) {
        if (flowerbed[i] == 0
            && (i == 0 || flowerbed[i - 1] == 0)
            && (i == flowerbed.size - 1 || flowerbed[i + 1] == 0)) {
            flowerbed[i] = 1
            result--

            if (result == 0)
                return true
        }
    }
    return false
}
