package org.example

import java.text.DecimalFormat
import java.util.Stack

fun main() {
    println("Hello World!")
    val arr: Array<Int> = arrayOf(1, 1, 0, -1, -1)
    //plusMinus(arr)
    val arr2 = arrayOf(1,2,3,4,5)
    //miniMaxSum(arr2)
    //println(timeConversion("02:34:50PM"))
    //fizzBuzz(15)
    //println(findMedian(arr2))
//    println(lonelyinteger(arrayOf(1,2,3,4,3,2,1, 99, 99))) // 1 <= n < 100
//    println(lonelyinteger2(arrayOf(1,2,3,4,3,2,1, 99, 99))) // 1 <= n < 100
    println(compareStrings("yf#c#", "yy#k#pp##"))
}

fun plusMinus(arr: Array<Int>): Unit {
    // Write your code here
    var pos: Int = 0
    var neg: Int = 0
    var zero: Int = 0

    for (a in arr) {
//        if (a < 0)
//            neg++
//        else if (a > 0)
//            pos++
//        else
//            zero++
//
        when(a) {
            in Int.MIN_VALUE..-1 -> neg++
            in 1..Int.MAX_VALUE -> pos++
            else -> zero++
        }
    }
    val arrSize: Double = arr.size.toDouble()

    val dec = DecimalFormat("##0.000000")
    val ratioPos = dec.format(pos / arrSize)
    val ratioNeg = dec.format(neg / arrSize)
    val ratioZero = dec.format(zero / arrSize)

    println("Ratios for pos, neg and zeros are: " + ratioPos + ", " + ratioNeg + ", " + ratioZero)
}

fun miniMaxSum(arr: Array<Int>): Unit {
    var min = Int.MAX_VALUE
    var max = 0
    var total = 0L

    for (a in arr) {
        if (a < min)
            min = a
        if (a > max)
            max = a
        total += a
        println(total)
    }

    println("${total - max}  ${total - min}")

}

fun timeConversion(s: String): String {
    // Write your code here
    val a = s.substring(0, 8).toCharArray()
    if (s.substring(8, 9).equals("a", ignoreCase = true)) {
        if (a[0] == '1' && a[1] == '2') {
            a[0] = '0'
            a[1] = '0'
        }
    } else {
        if (a[0] == '1' && a[1] == '2') {
            return String(a)
        } else {
            val hrs = (s.substring(0, 2).toInt() + 12).toString().toCharArray()
            a[0] = hrs[0]
            a[1] = hrs[1]
        }
    }

    return String(a)
}

fun fizzBuzz(n: Int): Unit {
    // Write your code here
    for (i in 1..n) {
        if (i.mod(3) == 0 && i.mod(5) == 0)
            println("FizzBuzz")
        else if (i.mod(3) == 0)
            println("Fizz")
        else if (i.mod(5) == 0)
            println("Buzz")
        else
            println(i)

    }
}

fun findMedian(arr: Array<Int>): Int {
    // Write your code here
    if (arr.isEmpty())
        return -1
    arr.sort()
    val index = arr.size / 2
    return arr[index]
}

fun lonelyinteger(arr: Array<Int>): Int {
    // Write your code here
    val arr2 = IntArray(100)
    for (a in arr) {
        arr2[a]++
    }
    for (i in arr2.indices) {
        if (arr2[i] == 1)
            return i
    }
    return -1
}

fun lonelyinteger2(arr: Array<Int>): Int {
    // Write your code here
    arr.sort()

    for (i in 0 until arr.size - 1) {
        if (i.mod(2) == 0 && arr[i] != arr[i + 1])
            return arr[i + 1]
    }
    return -1
}

fun compareStrings(s1: String, s2: String): Int {

    val stack = Stack<Char>()
    for (c in s1.toCharArray()) {
        if (c == '#' && !stack.isEmpty()) {
            stack.pop()
        } else {
            stack.push(c)
        }
    }

    val stack2 = Stack<Char>()
    for (c in s2.toCharArray()) {
        if (c == '#' && !stack2.isEmpty()) {
            stack2.pop()
        } else {
            stack2.push(c)
        }
    }

    if (stack.size != stack2.size) {
        return 0
    } else {
        while (!stack.isEmpty()) {
            if (stack.pop() != stack2.pop())
                return 0
        }
    }

    return 1
}

