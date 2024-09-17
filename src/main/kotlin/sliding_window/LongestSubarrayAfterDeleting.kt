package org.example.sliding_window

/*
1493. Longest Subarray of 1's After Deleting One Element
Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's
in the resulting array. Return 0 if there is no such subarray.

Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2,
[1,1,1] contains 3 numbers with value of 1's.

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4,
[0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
* */

fun main() {
    val nums = intArrayOf(1,1,0,1)
    val nums2 = intArrayOf(0,1,1,1,0,1,1,0,1)
    val nums3 = intArrayOf(1,1,1)
    println(longestSubarray2(nums))
    println(longestSubarray2(nums2))
    println(longestSubarray2(nums3))
}

fun longestSubarray(nums: IntArray): Int {
    var startIndex = 0
    var endIndex = 0
    var maxLength = 0
    var delCount = 0

    while (endIndex < nums.size) {
        // If we encounter a 0, increment the zeroCount
        if (nums[endIndex] == 0) {
            delCount++
        }

        // If delCount exceeds 1, move startIndex to the right
        // until delCount is no longer greater than 1
        while (delCount > 1) {
            if (nums[startIndex] == 0) {
                delCount--
            }
            startIndex++
        }

        // Calculate the max length of the window
        maxLength = maxOf(maxLength, endIndex - startIndex)
        endIndex++
    }

    return maxLength
}

fun longestSubarray2(nums: IntArray): Int {
    var start = 0 // start of range. Moves every iteration
    var end = 0 // end of range. Moves when we can't use flips
    var delCount = 1 // count of possible deletions

    while(start < nums.size){
        if(nums[start] == 0){ // faced with zero. we can delete
            delCount--
        }

        if(delCount < 0) { // flips are finished, we have to move end of range
            if(nums[end] == 0){ // if released symbol is zero, we returned one flip
                delCount++
            }
            end++ //checked released symbol, and then, moved end of range
        }

        start++
    }
    return start - end - 1
}

fun longestSubarray3(nums: IntArray): Int {
    var result = 0
    var start = 0
    var k = 1
    for(end in nums.indices){
        if(nums[end] == 0){
            //if k==0, it means we already have one zero
            //in the window, so shrink it
            while(k == 0){
                if(nums[start] == 0) k++
                start++
            }
            k--
        }
        val window = end - start
        result = maxOf(result, window)
    }
    return result
}

fun longestSubarray4(nums: IntArray): Int = when {
    0 !in nums -> nums.size - 1
    else -> nums.joinToString("").split('0').zipWithNext { a, b -> a.length + b.length }.max()
}
