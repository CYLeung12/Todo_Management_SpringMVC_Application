# Todo Management Application
This is a Spring MVC Web Application for managing personal todo list. It was built when I was working through [an online course](#reference).


## Application Overview
The following functions are available with the application:
* Login/Logout function
* Add / update / remove todo item
* English or Chinese UI
* Basic REST service to get todo item in Jsons

The following tools are used to build the application
* JSP webpage - View layers are built with JSP webpages
* Bootstrap - The CSS framework is used to style the webpages
* DispatcherServlet - Defined in web.xml as a front controller to direct any requests to the corresponding controller
* Spring Security - For account authentication for log in function and access control for unauthenticated user
* Hibernate Validator - Provide bean validation for Todo class
* JSTL & Spring Tags - Provide useful functions on JSP pages such as for-each loop and form-binding
* Internationalization - Use path parameter to get the preferred language and set the response page label values from the properties file.
* @RestController and jackson-databind - Provide simple REST service for retrieving todo items

## Running Example
Please use the following testing account to log in the application:
* Username: test
* Password: pw

## Future Development
* Customise login page
* External databases storing user accounts and todo items
* Unit tests

## Reference
The building of the application referred to the online course:
https://www.udemy.com/course/spring-mvc-tutorial-for-beginners-step-by-step/