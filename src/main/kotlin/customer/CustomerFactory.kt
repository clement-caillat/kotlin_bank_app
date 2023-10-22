package customer

object CustomerFactory {
    fun create(firstName: String, lastName: String ) : Customer {
        return Customer(firstName, lastName)
    }
}

data class Customer(val firstName: String, val lastName: String)