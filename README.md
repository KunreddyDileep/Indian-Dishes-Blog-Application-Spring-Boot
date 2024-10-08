**Indian Dishes Blog Application with Spring Boot**

This is a Spring Boot web application integrated with Thymeleaf for server-side rendering. The application allows users to view and interact with posts, incorporating user roles and authorization using Spring Security. The front-end templates are dynamically rendered using Thymeleaf, ensuring secure access based on user roles. The application connects to a MySQL database to store and retrieve post data.

**Features:**
* Spring Boot for backend development
* Thymeleaf for dynamic HTML rendering
* Spring Security for role-based access control
* Integration with MySQL database for data persistence
* RESTful API endpoints for managing posts
* Error handling with custom exception handling

**Prerequisites:**
* Java 11 or higher
* Maven
* MySQL Database
* IDE (e.g., IntelliJ IDEA, Eclipse)
* Git

**Installation & Execution Steps**
**1. Clone the repository:**

* ![Screenshot 2024-10-08 131041](https://github.com/user-attachments/assets/97d021ec-22f2-4d69-b935-a7e1daa1504f)

**2. Configure the MySQL Database:**
* Create a MySQL database and update the application.properties file with your database credentials:
![Screenshot 2024-10-08 131151](https://github.com/user-attachments/assets/2c9c03f9-09fd-488c-bf0f-6af8e1b6b957)

**3. Build the project:**

* ![Screenshot 2024-10-08 131533](https://github.com/user-attachments/assets/ff749b41-e190-4cd0-9f22-8cfba88f8051)

**4. Run the application:**

* ![Screenshot 2024-10-08 131713](https://github.com/user-attachments/assets/0db1c9c4-7a52-431d-84d6-ee59873398fd)

**5. Access the application:** Open your browser and navigate to http://localhost:8080.

**6. Login Details:**

* Admin role: Username: admin, Password: admin
* User role: Username: user, Password: user

**Troubleshooting:**
* Ensure that the MySQL database is running.
* Check that the database configurations are correctly set in application.properties.
* If encountering template parsing errors, verify that Thymeleaf templates are correctly structured and expressions are supported by Spring Security.



