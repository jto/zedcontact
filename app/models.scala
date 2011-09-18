package models

import java.util.Date
import scalaz._
import Scalaz._

import validators.Validators._
sealed trait ContactName extends NewType[String]
object ContactName {
  def apply(s: String) = length(s, 3) ∘ {n => new ContactName{val value = n}}
}

sealed trait BirthDate extends NewType[Date]
object BirthDate{
  def apply(d: Date) = past(d) ∘ {n => new BirthDate{val value = n}}
}

sealed trait Email extends NewType[String]
object Email{
  def apply(s: String) = (length(s, 5) *> contains(s, "@")) ∘ { n => new Email{val value = n}}
}

case class Contact(
    id: Option[Int],
    firstname: ContactName,
    lastname: ContactName,
    birthdate: BirthDate,
    email: Option[Email]
)

object Contact{
  def apply(id: Option[Int], firstname: String, lastname: String, birthdate: Date, email: Option[String]) = {
    (ContactName(firstname) ⊛ ContactName(lastname) ⊛ BirthDate(birthdate)){
      new Contact(id, _, _, _, Email("titi@toto").toOption)
    }
  }
}

