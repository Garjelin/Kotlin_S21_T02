package model

internal class Dog(initName: String?, initAge: Int?) : Animal(initName, initAge) {
    override fun toString(): String {
        return "Dog name = " + super.name + ", age = " + super.age
    }
}
