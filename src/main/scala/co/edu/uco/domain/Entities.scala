package co.edu.uco.domain

object Entities {

  sealed trait BankAccount{
    val balance:Long
    val number: Int
  }

  case class SavingAccount(balance:Long, number:Int) extends BankAccount

  case class CheckingAccount(balance:Long, number:Int, interest:Long) extends BankAccount

}
