package org.example.two_pointers

/*
1679. Max Number of K-Sum Pairs
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
* */

fun main() {
    val nums = intArrayOf(1,2,3,4)
    val k = 5
    val nums2 = intArrayOf(3,1,3,4,3)
    val k2 = 6
    val k3 = 5
    val k4 = 2
    val nums5 = intArrayOf(4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4)
    val k5 = 2

    println(maxOperations2(nums, k))
    println(maxOperations2(nums2, k2))
    println(maxOperations2(nums2, k3))
    println(maxOperations2(nums2, k4))
    println(maxOperations2(nums5, k5))
}

fun maxOperations(nums: IntArray, k: Int): Int {
    //my solution is too slow
    var result = 0
    if (nums.size == 1) {
        result = if (nums[0] == k)
            1
        else
            0
    } else {
        var i = 0
        var j = 1

        while (i < j && i < nums.size - 1) {
            if (nums[i] + nums[j] == k
                && nums[i] != 0
                && nums[j] != 0) {
                result++
                nums[i] = 0
                nums[j] = 0
            }
            j++
            if (j > nums.size - 1) {
                i++
                j = i + 1
            }
        }
    }

    return result
}

fun maxOperations2(nums: IntArray, k: Int): Int {
    //O(nlogn)
    var result = 0
    if (nums.size == 1) {
        result = if (nums[0] == k)
            1
        else
            0
    } else {
        nums.sort() //this sorting causes that the input array changes and the "resulting array" won't be like in the Example 2
        var i = 0
        var j = nums.size - 1

        while (i < j) {
            if (nums[i] + nums[j] == k) {
                result++
                i++
                j--
            } else if (nums[i] + nums[j] > k) {
                j--
            } else {
                i++
            }
        }
    }

    return result
}