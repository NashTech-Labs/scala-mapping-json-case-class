import com.knoldus.{CaseClassToJson, Employee, JsonToCaseClass}

object Driver extends App{
  val jsonIntoCaseClassObj=new JsonToCaseClass
  val simpleJsonString:String=
  """
  {
    "employees": [{
    "firstName": "John",
    "lastName": "Doe",
    "department": "Engineering",
    "designation": "Developer"

  },
    {
      "firstName": "Anna",
      "lastName": "Smith",
      "department": "Marketing",
      "designation": "Sales Manager"

    },
    {
      "firstName": "Peter",
      "lastName": "Jones",
      "department": "Testing",
      "designation": "QA"
    }
    ]
  }"""
 val convertedJsonIntoCaseClass= jsonIntoCaseClassObj.convertSimpleJsonStringintoCaseClass(simpleJsonString)
  System.out.println(convertedJsonIntoCaseClass)

val employeeList=List(Employee(Option("Abhinav"),Option("Sharma"),Option("Engineering"),Option("Developer")),
  Employee(Option("Akash"),Option("Sharma"),Option("Marketing"),Option("Sales Manager")),
  Employee(Option("Amit"),Option("Sharma"),Option("Testing"),Option("QA")))
val caseClassToJsonObj=new CaseClassToJson
val convertedCaseClassToJson=caseClassToJsonObj.convertCaseClassToJson(employeeList)
  System.out.println(convertedCaseClassToJson)
val nestedJson=
"""{
	"employees": [{
    "firstName": "John",
    "lastName": "Doe",
    "department": "Engineering",
    "designation": "Developer",
    "address": {
      "area": "sec 22",
      "city": "Moscow"
    }

  },
  {
    "firstName": "Anna",
    "lastName": "Smith",
    "department": "Marketing",
    "designation": "Sales Manager",
    "address": {
      "area": "Brooklyn",
      "city": "New York"
    }

  },
  {
    "firstName": "Peter",
    "lastName": "Jones",
    "department": "Testing",
    "designation": "QA",
    "address": {
      "area": "California",
      "city": "Los Angeles"
    }
  }
  ]
}"""
val convertedNestedJsonToCaseClass=jsonIntoCaseClassObj.convertNestedJsonStringintoCaseClass(nestedJson)
  System.out.println(convertedNestedJsonToCaseClass)
}
