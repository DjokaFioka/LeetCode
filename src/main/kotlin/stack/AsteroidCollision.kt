package org.example.stack

import java.util.*

/*
* 735. Asteroid Collision
We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
* */

fun main() {
    val asteroids = intArrayOf(5,10,-5)
    val asteroids2 = intArrayOf(8, -8)
    val asteroids3 = intArrayOf(10, 2, -5)
    for (a in asteroidCollision(asteroids))
        print("$a, ")
    println()
    println("--------------------")
    for (a in asteroidCollision(asteroids2))
        print("$a, ")
    println()
    println("--------------------")
    for (a in asteroidCollision(asteroids3))
        print("$a, ")
    println()
    println("--------------------")
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = Stack<Int>()

    for (ast in asteroids) {
        if (stack.isEmpty()) {
            stack.push(ast)
        } else {
            var a = ast
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                val diff = a + stack.peek()
                if (diff < 0) {
                    stack.pop()
                } else if (diff > 0) {
                    a = 0
                } else {
                    stack.pop()
                    a = 0
                }
            }

            if (a != 0)
                stack.push(a)
        }
    }

    return stack.toIntArray()
}