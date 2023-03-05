import kotlin.random.Random

fun main() {
    val answer = generateAnswer()
    var guessed = false

    while (!guessed) {
        println("Guess a 4-digit number with no repeating digits:8576")
        val guess = readLine()
        if (guess != null && guess.length == 4 && guess.toSet().size == 4) {
            val result = checkGuess(guess, answer)
            println(result)
            if (result == "4:4") {
                println("Congratulations! You guessed the number.")
                guessed = true
            }
        } else {
            println("Invalid input. Please enter a 4-digit number with no repeating digits.")
        }
    }
}

fun generateAnswer(): String {
    val digits = mutableListOf<Int>()
    while (digits.size < 4) {
        val digit = Random.nextInt(10)
        if (!digits.contains(digit)) {
            digits.add(digit)
        }
    }
    return digits.joinToString("")
}

fun checkGuess(guess: String, answer: String): String {
    var n = 0
    var m = 0
    for ((i, digit) in guess.withIndex()) {
        if (answer.contains(digit)) {
            n++
        }
        if (digit == answer[i]) {
            m++
        }
    }
    return "$n:$m"
}
