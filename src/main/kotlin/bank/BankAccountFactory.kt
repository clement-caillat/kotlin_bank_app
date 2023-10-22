package bank

import customer.Customer
import customer.CustomerFactory

enum class BankAccountType {
    BLUE, GOLD, BLACK;

    fun getFormattedName() = name.take(3)
}

object BankAccountFactory {
    fun create(type: BankAccountType, customerFirstname: String, customerLastname: String) : BankAccount {

        val customer = CustomerFactory.create(customerFirstname, customerLastname)

        val accountId: String = createAccountId(type, customer)

        return BankAccount(accountId, customer)
    }
}


class BankAccount(private val accountId: String, private val accountHolder: Customer) {
    private var amount: Float = 0.0f


    private fun formattedAmount(): String {
        return String.format("%.2f", amount)
    }

    fun printInfo() {
        println("-----------------")
        println("Account id : $accountId")
        println("Account holder : ${accountHolder.firstName} ${accountHolder.lastName}")
        println("Amount : ${formattedAmount()}€")
        println("-----------------")
    }

    fun withdraw(withdrawAmount: Float) {
        if (withdrawAmount > this.amount) {
            println("Not enough fund")
            return
        }

        this.amount -= withdrawAmount

        println("You withdrawed $withdrawAmount€")
    }

    fun deposit(depositAmount: Float) {
        this.amount += depositAmount

        println("You deposit $depositAmount€")
    }
}



private fun createAccountId(accountType: BankAccountType, customer: Customer): String {
    return "FRLUCD${accountType.getFormattedName()}${customer.firstName.take(3).uppercase()}${customer.lastName.take(5).uppercase()}"
}