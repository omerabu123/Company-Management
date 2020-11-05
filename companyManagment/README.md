��� �����, ������ ���� ������.


�� ������ ������ �localhost:8080/api �� EndPoints, Swagger.  
����� �Junit �Mockito - �� ������ ���� ����� ����� ������� �� ����� ���� ����� ������ ����� �Services- ��� ����� ���� ��� �����.
����� actuator ���� ������ �� Health, ���� ����� ���� ���  localhost:8080/api/actuator/myHealth .

����� �PostMan Collection :  
https://www.getpostman.com/collections/07f9caad87a202cf9afa

����� ������ Swagger : 
https://www.getpostman.com/collections/3cf27879f866a4d2bef2

������ ����� ���� Postman collection ��� ���� ���� ��� ���� Body, ������ �� �� Json �� ��� ���� ����� ����� ������.
 
���� ����: 

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