package org.example.sliding_window

/*
643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value
and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000
* */

fun main() {
    val nums = intArrayOf(1,12,-5,-6,50,3)
    val k = 4

    val nums2 = intArrayOf(5)
    val k2 = 1

    println(findMaxAverage(nums, k))
    println(findMaxAverage(nums2, k2))
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var maxAvg = 0.0
    var currAvg = 0.0
    var l = k
    var i = 0
    while(i < k) {
        currAvg += nums[i++]
    }
    maxAvg = currAvg
    for (n in 1 .. nums.size - k) {
        currAvg = currAvg - nums[n - 1] + nums[l++]
        maxAvg = maxOf(maxAvg, currAvg)
    }
    return maxAvg / k
}

//Better
fun findMaxAverage2(nums: IntArray, k: Int): Double {
    var answer = 0
    var sum = 0

    // Find our first window, sum of the first k elements
    for (i in 0 until k) {
        sum += nums[i]
    }

    answer = sum

    // For every other window, update the sum.
    // Keep track of highest so far.
    for (i in k until nums.size) {
        sum += nums[i] - nums[i - k]
        answer = maxOf(answer, sum)
    }

    // Calculate average of the highest we saw and return
    return answer.toDouble() / k
}

