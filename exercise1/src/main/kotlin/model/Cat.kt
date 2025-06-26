package model

internal class Cat(initName: String?, initAge: Int?) : Animal(initName, initAge) {
    override fun toString(): String {
        return "Cat name = " + super.name + ", age = " + super.age
    }
}