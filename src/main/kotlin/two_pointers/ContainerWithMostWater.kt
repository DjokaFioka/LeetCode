package org.example.two_pointers

/*
11. Container With Most Water
You are given an integer array height of length n.
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
* */

fun main() {
    val height = intArrayOf(1,8,6,2,5,4,8,3,7)
    val height2 = intArrayOf(1,2,1)

    println(maxArea(height))
    println(maxArea(height2))
}

fun maxArea(height: IntArray): Int {
    // sanity check
    if (height.isEmpty())
        return 0

    val size = height.size
    var lo = 0
    var hi = size - 1
    var maxArea = 0

    while(lo < hi){
        println("lo = $lo, hi = $hi")
        println("height[lo] = ${height[lo]}, height[hi] = ${height[hi]}, minOf = ${minOf(height[lo], height[hi])}")
        val area = minOf(height[lo], height[hi]) * (hi - lo)
        maxArea = maxOf(maxArea, area)

        println("Area = $area, maxArea = $maxArea")
        if(height[lo] < height[hi])
            lo++
        else
            hi--
    }

    return maxArea
}