package customException

class InputErrorException(message: String = "Input error. Size <= 0") : Exception(message)

class InputBlankException(message: String = "Name is blank. Try again") : Exception(message)

class UnsupportedPetTypeException(message: String = "Incorrect input. Unsupported pet type") : Exception(message)