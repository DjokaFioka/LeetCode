package org.example.prefix_sum

/*
724. Find Pivot Index
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index
is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array,
then the left sum is 0 because there are no elements to the left.
This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2:
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

Example 3:
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
* */

fun main() {
    val nums = intArrayOf(1,7,3,6,5,6)
    val nums2 = intArrayOf(1,2,3)
    val nums3 = intArrayOf(2,1,-1)

    println(pivotIndex(nums))
    println(pivotIndex(nums2))
    println(pivotIndex(nums3))
}
//Calculate the total sum of the array
//Loop through again and check if the double value of the current sum is equal
// to the total sum minus the value at the current index
fun pivotIndex(nums: IntArray): Int {
    var totalSum = 0

    nums.forEach {
        totalSum += it
    }

    var curSum = 0

    for (i in 0 until nums.size) {
        if (curSum * 2 == totalSum - nums[i])
            return i
        curSum += nums[i]
    }

    return -1
}

//faster
fun pivotIndex2(nums: IntArray): Int {
    var sumLeft = 0
    var sumRight = 0

    nums.forEach {sumRight += it}

    nums.forEachIndexed { index, value ->
        sumRight -= value
        if(sumLeft == sumRight) {
            return index
        } else {
            sumLeft += value
        }
    }
    return -1
}