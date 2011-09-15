package models

import java.util.Date

case class Contact(
    id: Int,
    firstname: String,
    name: String,
    birthdate: Date,
    email: Option[String]
)