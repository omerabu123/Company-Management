היי ליאור, מצורפת מטלה מבוצעת.


כל המערכת מנותבת לlocalhost:8080/api גם EndPoints, Swagger.  
בנוגע לJunit וMockito - לא ביצעתי הרבה טסטים כיוון שהמערכת לא מכילה הרבה עיבוד נתונים בשלבי הServices- ולא מצאתי יותר מדי שימוש.
יצרתי actuator משלי למימוש של Health, תוכל למצוא אותו דרך  localhost:8080/api/actuator/myHealth .

קישור לPostMan Collection :  
https://www.getpostman.com/collections/07f9caad87a202cf9afa

קישור לאחזור Swagger : 
https://www.getpostman.com/collections/3cf27879f866a4d2bef2

בפעולת הוספת עובד Postman collection כבר קיים עובד אחד בתוך Body, הוספתי לך פה Json של עוד עובד למקרה שתרצה להוסיף.
 
עובד נוסף: 

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