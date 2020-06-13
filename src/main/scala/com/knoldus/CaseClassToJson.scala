package com.knoldus

import com.typesafe.scalalogging.LazyLogging
import net.liftweb.json.Extraction.decompose
import net.liftweb.json.{DefaultFormats, compactRender}

class CaseClassToJson extends LazyLogging{
  implicit val formats: DefaultFormats.type = DefaultFormats


  def convertCaseClassToJson(employeeList:List[Employee]):String={
    logger.info("converting list of case class of employee to json")

    compactRender(decompose(employeeList))
  }

}
