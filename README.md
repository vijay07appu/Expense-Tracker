📊 Expense Tracker – Spring Boot Project

A simple and efficient Expense Tracker Application built using Spring Boot, JPA, and MySQL.
This application allows users to manage their daily expenses and export data to a CSV file.

🚀 Features

✅ Add new expenses

✅ View all expenses

✅ Update expense details

✅ Delete expenses

✅ Input validation (no empty description, valid amount)

✅ Auto-generated ID using JPA

✅ Export all expenses to CSV file


🛠️ Tech Stack

Java 17+

Spring Boot

Spring Data JPA

Hibernate

MySQL

Maven

📂 Project Structure
expensetracker
│── controller
│── service
│── repository
│── model
│── dto
│── exception
└── resources

⚙️ Setup Instructions
1️⃣ Clone the Repository
git clone https://github.com/your-username/expensetracker.git
cd expensetracker

2️⃣ Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/expensetracker
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Run the Application
mvn spring-boot:run


Application runs at:

http://localhost:8080

📤 Export Expenses to CSV

The application provides a feature to download all stored expenses as a CSV file.

API Endpoint:
GET /api/expenses/export


When this endpoint is called:

📥 A CSV file (expenses.csv) is generated

📊 All expense records from the database are included

CSV Format Example:
ID,Description,Amount,Category
1,Food,200,Groceries
2,Petrol,500,Transport

🔐 Validation

The application includes proper validation to ensure:

Description is not blank

Amount is positive

Required fields are not null

Custom validation logic is implemented without using Bean Validator.

💡 Future Improvements

Add user authentication (JWT)

Add date filtering

Add monthly and yearly summaries

Add pagination

Export filtered data

Export to Excel (.xlsx)

👨‍💻 Author

Vijay JD
