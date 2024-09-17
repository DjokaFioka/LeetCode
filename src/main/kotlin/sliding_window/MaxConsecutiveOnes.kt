package org.example.sliding_window

/*
1004. Max Consecutive Ones III
Given a binary array nums and an integer k,
return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1*,1,1,1,1,1*]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1*,1*,1,1,1,1*,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
* */

fun main(){
    val nums = intArrayOf(1,1,1,0,0,0,1,1,1,1,0)
    val k = 2

    val nums2 = intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1)
    val k2 = 3

    println(longestOnes(nums, k))
    println(longestOnes(nums2, k2))
}

fun longestOnes(nums: IntArray, k: Int): Int {
    var startIndex = 0
    var endIndex = 0
    var maxLength = 0
    var zeroCount = 0

    while (endIndex < nums.size) {
        // If we encounter a 0, increment the zeroCount
        if (nums[endIndex] == 0) {
            zeroCount++
        }

        // If zeroCount exceeds k, move startIndex to the right
        // until zeroCount is no longer greater than k
        while (zeroCount > k) {
            if (nums[startIndex] == 0) {
                zeroCount--
            }
            startIndex++
        }

        // Calculate the max length of the window
        maxLength = maxOf(maxLength, endIndex - startIndex + 1)
        endIndex++
    }

    return maxLength
}

fun longestOnes2(nums: IntArray, k: Int): Int {
//Two pointer (fast and slow)
    var start = 0 // start of range. Moves every iteration
    var end = 0 // end of range. Moves when we can't use flips
    var flipCount = k // count of possible flips

    while(start < nums.size){
        if(nums[start] == 0){ // faced with zero. spending 1 flip
            flipCount--
        }

        if(flipCount < 0) { // flips are finished, we have to move end of range
            if(nums[end] == 0){ // if released symbol is zero, we returned one flip
                flipCount++
            }
            end = end + 1 //checked released symbol, and then, moved end of range
        }

        start++
    }
    return start - end // difference between start and end - our maximum range
}




