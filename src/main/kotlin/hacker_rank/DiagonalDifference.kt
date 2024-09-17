package org.example.hacker_rank

import kotlin.math.abs

/*
* Given a square matrix, calculate the absolute difference between the sums of its diagonals.
For example, the square matrix  is shown below:
3
1 2 3
4 5 6
9 8 9
The left-to-right diagonal = 15. The right to left diagonal = 17. Their absolute difference is 2
* */

fun main() {
    val n = readLine()!!.trim().toInt()

    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)

//    val arr = arrayOf(
//        arrayOf(3),
//        arrayOf(11, 2, 4),
//        arrayOf(4, 5, 6),
//        arrayOf(10, 8, -12)
//    )
    val arr2 = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(9, 8, 9)
    )
    println(diagonalDifference(arr2))
}

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var sumLeft = 0
    var sumRight = 0
    val arrSize = arr.size - 1
    for (i in 0 .. arrSize) {
        sumLeft += arr[i][i]
        sumRight += arr[i][arrSize - i]
    }

    return abs(sumLeft - sumRight)
}