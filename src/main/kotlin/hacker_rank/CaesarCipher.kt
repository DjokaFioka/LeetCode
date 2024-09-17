package org.example.hacker_rank

/*
HackerRank
Julius Caesar protected his confidential information by encrypting it using a cipher.
Caesar's cipher shifts each letter by a number of letters.
If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet.
In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
* */

fun main() {
    val input = "middle-Outz"
    val input2 = "www.abc.xy"
    val rotate = 87
    println(caesarCipher2(input2, rotate))
}

fun caesarCipher(s: String, k: Int): String {
    val alphabet = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    val m = k % alphabet.size
    val sb: StringBuilder = StringBuilder()

    for (letter in s) {
        val isUpperCase = letter.isUpperCase()
        val i = alphabet.indexOf(letter.lowercaseChar())
        if (i == -1)
            sb.append(letter)
        else {
            if (i + m > alphabet.size - 1) {
                sb.append(if (isUpperCase) alphabet[i + m - alphabet.size].uppercase() else alphabet[i + m - alphabet.size])
            } else {
                sb.append(if (isUpperCase) alphabet[i + m].uppercase() else alphabet[i + m])
            }
        }
    }

    return String(sb)
}

fun caesarCipher2(word: String, k: Int): String {
    val alphabetSize = 26
    val sb: StringBuilder = StringBuilder()

    for (letter in word) {
        when (letter) {
            in 'a'..'z' -> {
                sb.append('a' + ((letter - 'a' + k) % alphabetSize))
            }
            in 'A'..'Z' -> {
                sb.append('A' + ((letter - 'A' + k) % alphabetSize))
            }
            else -> {
                sb.append(letter)
            }
        }
    }

    return String(sb)
}