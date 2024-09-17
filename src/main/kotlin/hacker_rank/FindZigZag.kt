package org.example.hacker_rank

/*
HackerRank
In this challenge, the task is to debug the existing code to successfully execute all provided test files.
Given an array of n distinct integers,
transform the array into a zig zag sequence by permuting the array elements.
A sequence will be called a zig zag sequence if the first k elements in the sequence
are in increasing order and the last k elements are in decreasing order,
where k = (n + 1) / 2. You need to find the lexicographically smallest zig zag sequence of the given array.

Example:
arr = [2,3,5,1,4]
answer = [1,4,5,3,2]
* */

fun main() {
    val testCases = readLine()!!.toInt()
    repeat(testCases) {
        val n = 7//readLine()!!.toInt()
        val a = intArrayOf(1,2,3,4,5,6,7).toMutableList()//readLine()!!.split(" ").map { it.toInt() }.toMutableList()
        findZigZagSequence(a, n)
    }
}

fun findZigZagSequence(a: MutableList<Int>, n: Int) {
    a.sort()
    val mid = (n + 1) / 2
    a[mid] = a[n - 1].also { a[n - 1] = a[mid] }

    var st = mid + 1
    var ed = n - 1
    while (st <= ed) {
        a[st] = a[ed].also { a[ed] = a[st] }
        st++
        ed--
    }

    for (i in 0 until n) {
        print(if (i == n - 1) "${a[i]}\n" else "${a[i]} ")
    }
}