package co.edu.uco.service

import co.edu.uco.domain.Entities
import co.edu.uco.domain.Entities.{BankAccount, CheckingAccount, SavingAccount}
import co.edu.uco.persistence.BankAccountPersistence

class BankAccountService(bankAccountPersistence: BankAccountPersistence) {


  //ACCION QUE RETIRA CIERTA CANTIDAD DE DINERO DE UNA CUENTA
  def debit(bankAccount: BankAccount, amount: Long): Option[BankAccount] = {

    Some(amount).filter(_ > 0).map(am => bankAccount match {
      case SavingAccount(balance, number) => SavingAccount(balance - am, number)
      case Entities.CheckingAccount(balance, number, interest) => CheckingAccount(balance - am, number, interest)
    }).flatMap(bankAccount => bankAccountPersistence.save(bankAccount))
  }

  //ACCION QUE CONSIGNA CIERTA CANTIDAD DE DINERO A UNA CUENTA
  def credit(bankAccount: BankAccount, amount: Long): Option[BankAccount] = {

    Some(amount).filter(_ > 0).map(am => bankAccount match {
      case SavingAccount(balance, number) => SavingAccount(balance + am, number)
      case Entities.CheckingAccount(balance, number, interest) => CheckingAccount(balance + am, number, interest)
    }).flatMap(bankAccount => bankAccountPersistence.save(bankAccount))
  }

}
