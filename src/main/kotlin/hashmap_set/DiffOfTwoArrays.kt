package org.example.hashmap_set

/*
2215. Find the Difference of Two Arrays
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Example 1:
Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2,
whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2.
Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1,
whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2.
Therefore, answer[1] = [4,6].

Example 2:
Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2.
Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
* */

fun main() {
    val nums1 = intArrayOf(1,2,3)
    val nums2 = intArrayOf(2,4,6)

    findDifference(nums1, nums2).forEach { l ->
        l.forEach { num ->
            print("$num, ")
        }
        println()
        println("------------------")
    }
}

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val s1 = nums1.toMutableSet()
    val s2 = nums2.toMutableSet()

    nums2.forEach { num ->
        if (s1.contains(num))
            s1.remove(num)
    }

    nums1.forEach { num ->
        if (s2.contains(num))
            s2.remove(num)
    }

    return mutableListOf(s1.toList(), s2.toList())
}

fun findDifference2(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val s1 = nums1.toMutableSet()
    val s2 = nums2.toMutableSet()
    val nums1Distinct = arrayListOf<Int>()

    s1.forEach{
        if(!s2.contains(it))
            nums1Distinct.add(it)
        else{
            s2.remove(it)
        }
    }
    return listOf(nums1Distinct, s2.toList())
}
