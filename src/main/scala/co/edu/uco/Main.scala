package co.edu.uco

import co.edu.uco.domain.Entities.{CheckingAccount, SavingAccount}
import co.edu.uco.persistence.BankAccountPersistence
import co.edu.uco.service.BankAccountService

import java.lang.Error
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

object MainOption extends App {

  print("Escribe el número para calcular si es primo: ")
  val f = readLine().toInt

  val respuesta = (2 to f / 2).count(f % _ == 0) match {
    case x if x>0 => "No es Primo"
    case _ => "Es primo"
  }
  println(respuesta)

  //___________________________________

  print("Escribe T: Para triangulo, C: para Cuadrado, P: para pentágono ")

  val consolaValue = readLine()

  val definirFormula: (Int, Int) => Double = consolaValue match {
    case "T" => (base:Int, altura:Int) => base*altura/2.0
    case "C" => (base:Int, altura:Int) => base*altura.toDouble
    case "P" => (perimetro:Int, apotema:Int) => perimetro*apotema/2
  }


  def definirArea(formula: (Int,Int) => Double,valor1:Int, valor2:Int) ={
    formula.apply(valor1,valor2)
  }
  print("Digite el valor uno para calcular el area")
  val valor1 = readLine()
  print("Digite el valor dos para calcular el area")
  val valor2 = readLine()

  println(s"El area es: ${definirArea(definirFormula,valor1.toInt,valor2.toInt)}")

  //______________________________________________


}

object MainBannkAccount extends App{

  val bankAccountPersistence = new BankAccountPersistence
  val bankAccountService = new BankAccountService(bankAccountPersistence)

  val savingAccount = SavingAccount(323232,123)
  val checkingAccount = CheckingAccount(323232,123,1)

  bankAccountService.credit(savingAccount,100)
  bankAccountService.debit(checkingAccount,100)
}