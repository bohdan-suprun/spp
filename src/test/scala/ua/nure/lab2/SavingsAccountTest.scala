package ua.nure.lab2

import org.specs2.mutable.Specification

/**
 * @author Bohdan_Suprun
 */
class SavingsAccountTest extends Specification {

  "SavingsAccount" should {
    "not charge the customer 3times in a month" in {
      val account = new SavingsAccount(100)
      account deposit 10 mustEqual 110
      account deposit 10 mustEqual 120
      account deposit 10 mustEqual 130
      account deposit 10 mustEqual 139
    }

    "increase monthly counter and add percents to the customer's account" in {
      val account = new SavingsAccount(100)
      account deposit 10 mustEqual 110
      account deposit 10 mustEqual 120
      account deposit 10 mustEqual 130
      account deposit 10 mustEqual 139
      account.earnMonthlyInterest()
      account deposit 10 mustEqual 139 + 139 * 0.1 + 10
    }
  }

}
