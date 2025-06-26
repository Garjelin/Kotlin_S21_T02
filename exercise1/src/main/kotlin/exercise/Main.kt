package org.example.exercise

import customException.InputBlankException
import customException.InputErrorException
import customException.UnsupportedPetTypeException
import model.Animal
import model.Cat
import model.Dog
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var size = 0
    while (true) {
        try {
            val input = scanner.nextLine().trim()
            size = input.toIntOrNull() ?: throw InputErrorException("Couldn't parse a number. Please, try again")
            if (size <= 0) throw InputErrorException()
            scanner.nextLine()
            break
        } catch (exc: InputErrorException) {
            println(exc.message)
        }
    }
    while (true) {
        try {
            val pets: List<Animal> = List(size) {
                val initType = scanner.nextLine().trim()
                var type = ""
                when (initType) {
                    "dog" -> type = "dog"
                    "cat" -> type = "cat"
                    else -> throw UnsupportedPetTypeException()
                }
                val name = scanner.nextLine().trim()
                if (name.isBlank()) throw InputBlankException()
                val ageStr = scanner.nextLine().trim()
                val initAge = ageStr.toIntOrNull() ?: throw InputMismatchException()
                if (initAge <= 0) println("Incorrect input. Age <= 0")
                if (type === "dog") Dog(name, initAge)
                else Cat(name, initAge)
            }
            for (pet in pets) println(pet)
            break
        } catch (exc: InputBlankException) {
            println(exc.message)
            break
        } catch (exc: UnsupportedPetTypeException) {
            println(exc)
            break
        } catch (e: InputMismatchException) {
            println("Couldn't parse a number. Please, try again");
        }
    }
}