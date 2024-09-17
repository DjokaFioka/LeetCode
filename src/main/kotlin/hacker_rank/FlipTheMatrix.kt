package org.example.hacker_rank

fun main() {
    val arr = arrayOf(
        arrayOf(112, 42, 83, 119),
        arrayOf(56, 125, 56, 49),
        arrayOf(15, 78, 101, 43),
        arrayOf(62, 98, 114, 108)
    )

    val arr2 = arrayOf(
        arrayOf(1,2),
        arrayOf(3,4)
    )

    println(flippingMatrix(arr))
    println(flippingMatrix(arr2))
}

fun flippingMatrix(matrix: Array<Array<Int>>): Int {
    var result = 0
    val halfMatrixSize = matrix.size / 2
    val maxMatrixIndex = matrix.size - 1

    for (row in 0 until halfMatrixSize) {
        for (col in 0 until halfMatrixSize) {
            val element = matrix[row][col]
            val rightMirror = matrix[row][maxMatrixIndex - col]
            val downMirror = matrix[maxMatrixIndex - row][col]
            val rightDownMirror = matrix[maxMatrixIndex - row][maxMatrixIndex - col]

            result += listOf(element, rightMirror, downMirror, rightDownMirror)
                .maxOrNull() ?: 0
        }
    }
    return result
}