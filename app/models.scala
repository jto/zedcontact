package models

import java.util.Date

case class Contact(
    id: Option[Int],
    firstname: String,
    lastname: String,
    birthdate: Date,
    email: Option[String]
)