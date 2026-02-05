# Employee Management System – Documentation

## 1. Introduction
The Employee Management System is a Java-based console application used to store and manage employee information.  
It follows object-oriented design principles and uses file handling to store data permanently.

---

## 2. Objectives
- To understand Object-Oriented Programming in Java
- To implement CRUD operations
- To use serialization for file storage
- To generate meaningful reports from stored data

---

## 3. System Requirements
### Hardware
- Any system capable of running Java

### Software
- Java JDK 8 or above
- Command Prompt / Terminal
- Any Java IDE (optional)

---

## 4. Modules Description

### 4.1 Employee.java
- Represents the Employee entity
- Implements Serializable
- Stores:
  - Employee ID
  - Name
  - Department
  - Position
  - Salary
  - Join Date

---

### 4.2 EmployeeManagementSystem.java
- Main class of the application
- Displays the main menu
- Handles user input
- Controls application flow

---

### 4.3 EmployeeFileHandler.java
- Handles file operations
- Saves employee data into a file using serialization
- Loads employee data from file

---

### 4.4 EmployeeReportGenerator.java
- Generates various reports:
  - Department-wise summary
  - Salary statistics
  - Employee count by position
- Uses collections and stream operations

---

## 5. Reports Description

### 5.1 Department-wise Summary
- Displays number of employees in each department
- Shows average salary per department

### 5.2 Salary Statistics
- Total number of employees
- Total salary
- Average salary
- Highest and lowest salary with employee name

### 5.3 Employee Count by Position
- Displays number of employees for each job position

---

## 6. File Handling
- Employee data is stored in employees.dat
- Uses ObjectOutputStream and ObjectInputStream
- Ensures data persistence even after program termination

---

## 7. Conclusion
This project demonstrates practical usage of Java concepts such as OOP, collections, file handling, and menu-driven programming.  
It is suitable for academic submission and helps build a strong foundation in Core Java.

---