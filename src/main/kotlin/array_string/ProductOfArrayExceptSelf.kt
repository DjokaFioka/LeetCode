package org.example.array_string

/* 238. Product of Array Except Self
* Given an integer array nums, return an array answer such that answer[i] is equal
* to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/

fun main() {
    val nums1 = intArrayOf(1,2,3,4)

    print(productExceptSelf(nums1).joinToString(","))

}

fun productExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    var curr = 1

    //First we loop to get products of items before the index - we store the values in the resulting array
    //After this loop we'll get [1,1,2,6]
    for (i in nums.indices) {
        result[i] = curr
        curr *= nums[i]
    }

    //Then we loop from behind to get products of items after the index and multiply that with the value from the resulting array
    //We reset the curr to 1 because we already have the value in resulting array for the last item
    //After this loop we'll get [24,12,8,6]
    curr = 1
    for(i in nums.size - 1 downTo 0) {
        result[i] *= curr
        curr *= nums[i]
    }

    return result
}