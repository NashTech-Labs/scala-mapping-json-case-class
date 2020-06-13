package com.knoldus

import com.typesafe.scalalogging.LazyLogging
import net.liftweb.json.{DefaultFormats, parse}

case class Employee(firstName: Option[String], lastName: Option[String], department: Option[String], designation: Option[String])

case class Address(area: Option[String], city: Option[String])

case class EmployeeDetails(firstName: Option[String], lastName: Option[String], department: Option[String], designation: Option[String]
                          ,address: Address)

class JsonToCaseClass extends LazyLogging{
  implicit val formats: DefaultFormats.type = DefaultFormats

  def convertSimpleJsonStringintoCaseClass(str: String): List[Employee] = {
    logger.info("converting simple json of employees to list of case class of employee")
    val parsedJson = parse(str)
    (parsedJson \ "employees").children.map { employee =>
      val firstName = (employee \ "firstName").extract[Option[String]]
      val lastName = (employee \ "lastName").extract[Option[String]]
      val department = (employee \ "department").extract[Option[String]]
      val designation = (employee \ "designation").extract[Option[String]]
      Employee(firstName, lastName, department, designation)
    }
  }

  def convertNestedJsonStringintoCaseClass(str: String): List[EmployeeDetails] = {
    logger.info("converting nested json of employees to list of case class of employee")
    val parsedJson = parse(str)
    (parsedJson \ "employees").children.map { employee =>
      val firstName = (employee \ "firstName").extract[Option[String]]
      val lastName = (employee \ "lastName").extract[Option[String]]
      val department = (employee \ "department").extract[Option[String]]
      val designation = (employee \ "designation").extract[Option[String]]
      val area=(employee\"address"\"area").extract[Option[String]]
      val city=(employee\"address"\"city").extract[Option[String]]
      val address=Address(area,city)
      EmployeeDetails(firstName, lastName, department, designation,address)
    }
  }

}
