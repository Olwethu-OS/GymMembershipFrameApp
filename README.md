# GymMembershipFrameApp
The Membership Management System is a Java desktop application built using Swing and JDBC. It allows gym administrators to manage member information through a user-friendly graphical interface and a Derby database backend.

The application supports member registration, searching, updating, deletion, and displaying all registered members.

📌 **Features**
- Membership Registration: Add new gym members.
- Membership Management: View, update, and remove existing members.
- User-Friendly Interface: Built with Java Swing for a clean and interactive UI.
- Validate South African ID numbers before registration
- Store member data in an Apache Derby database

**Technologies Used**
-Java
-Java Swing (GUI)
-JDBC
-Apache Derby Database
-Object-Oriented Programming (OOP)
-DAO (Data Access Object) Design Pattern

**Database Configuration**

Default database settings:

String dburl = "jdbc:derby://localhost:1527/MembershipDB;create=true";
String username = "app";
String password = "123";

**MembersTbl Structure**

Column	  Data Type
Name	    VARCHAR
Surname	  VARCHAR
Id	      VARCHAR
Gender    VARCHAR
Trainer	  BOOLEAN
Contract	VARCHAR

**How to Run**
**Prerequisites**
-Java JDK 8 or higher
-Apache Derby Database
-NetBeans IDE 

**Steps**

1.Clone the repository:
git clone https://github.com/your-username/membership-management-system.git
2.Open the project in NetBeans.
3.Start the Derby Database server.
4.Create the MembershipDB database and MembersTbl table.
5.Run:
MembershipApp.java

