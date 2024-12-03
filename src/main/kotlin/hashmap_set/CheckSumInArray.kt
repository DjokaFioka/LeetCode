package org.example.hashmap_set

fun main() {
    val nums = intArrayOf(3, 5, 2, 8, 6)
    val k = 10

    println(checkSumInArray(nums, k))
}

fun checkSumInArray(intArray: IntArray, k: Int): Boolean {
    val seen = mutableSetOf<Int>()

    for (i in intArray) {
        if (seen.contains(k - i)) {
            return true
        } else {
            seen.add(i)
        }
    }

    return false
}