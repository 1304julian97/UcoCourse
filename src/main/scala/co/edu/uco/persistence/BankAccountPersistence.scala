package co.edu.uco.persistence

import co.edu.uco.domain.Entities
import scala.util.Random

class BankAccountPersistence {
  def save(bankAccount: Entities.BankAccount): Option[Entities.BankAccount] = {
    Random.nextInt(2) match {
      case 1 => Option.empty[Entities.BankAccount]
      case _ => Option.apply(bankAccount)
    }
  }

}
