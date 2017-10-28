package ua.nure.lab2

/**
 * @author Bohdan_Suprun
 */
class BankAccount(initialBalance: Double) {
  protected var balance = initialBalance

  def deposit(amount: Double) = {
    balance += amount
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }
}


class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = super.deposit(amount - 1)

  override def withdraw(amount: Double): Double = super.withdraw(amount + 1)
}

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var montCounter = 3
  private val monthDepositRate = 0.1

  override def deposit(amount: Double): Double = {
    super.deposit(if (isFreeOfCharge()) amount else amount - 1)
  }

  override def withdraw(amount: Double): Double = {
    super.withdraw(if (isFreeOfCharge()) amount else amount + 1)
  }

  def earnMonthlyInterest() = {
    montCounter = 3
    balance += balance * monthDepositRate
  }

  private def isFreeOfCharge(): Boolean = {
    montCounter -= (if (montCounter > -1) 1 else 0)
    montCounter > -1
  }
}

