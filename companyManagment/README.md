Hi lior, 
This is the assignement.

System path is localhost:8080/api includes Swagger, Actuator end points.
 
About Junit and Mockito, the system does not contain many data changes in the Service layers, therefore there is not a lot of testing.

I created a custom endpoint for health called "myHealth"
you can reach it within : 'localhost:8080/api/actuator/myHealth' .

Postman collection link:
https://www.getpostman.com/collections/07f9caad87a202cf9afa

Swagger JSON Link:
https://www.getpostman.com/collections/3cf27879f866a4d2bef2

In Postman collection method 'Add employee' body, you can find one employee to add, here is another one ready to be used by JSON.


Extra employee to add:

{
  "adress": {
    "apartmentNumber": 10,
    "streetName": "SumSum street",
    "streetNumber": 52
  },
  "children": [
    {
      "childID": 0,
      "generalDetails": {
        "citizenID": 11110000,
        "dateOfBirth": "2010-11-04T23:54:39.486Z",
        "gender": "Male",
        "name": "Yoram"
      },
      "lifeStage": "1st Grade"
    }
  ],
  "employeeID": 0,
  "generalDetails": {
    "citizenID": 101928483,
    "dateOfBirth": "1990-11-04T23:54:39.486Z",
    "gender": "Male",
    "name": "Roni"
  },
  "spouse": {
    "generalDetails": {
      "citizenID": 12918281,
      "dateOfBirth": "1992-11-04T23:54:39.486Z",
      "gender": "Male",
      "name": "Rinat"
    },
    "spouseID": 0,
    "yearsOfMarriage": 12
  }
}

-------------------------------------------------------------