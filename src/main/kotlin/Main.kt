import bank.BankAccount
import bank.BankAccountFactory
import bank.BankAccountType


fun main() {

    val account1: BankAccount = BankAccountFactory.create(BankAccountType.BLUE, "Clément", "Caillat")

    account1.printInfo()

    account1.deposit(100.2f)
    account1.withdraw(2.9f)

    account1.printInfo()

    account1.deposit(10.2f)
    account1.withdraw(200.0f)

}