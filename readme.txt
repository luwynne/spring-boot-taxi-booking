Spring Security

- This is the right spring security package: spring-boot-starter-security
- Spring security demands authentication for all the url's by default


You cannot add Spring Security to some url's, you have to add to everything. Then you can filter those requests by using Spring Security's filter

Inputs > Credentials from the user, email and password
Output > returns the principal, which is information about the logged user

AuthenticationProvider > an interface that has a method authenticate. Wee need to have an implementation of this class on our application
This is the method that checks the credentials and returns the principal information
the suppports() method is called when you need to find the right authentication provider for the app

Authentication manager: This is where the authentication can be configured and changed from the default to the DB
The way to work with the authentication manager is with the AuthenticationManagerBuilder, which is a builder pattern
The Authentication manager handles all the different types of authentication (authentication providers) the app might provide

UserDetailsService > class part of the Spring Security
takes the username and loads that user details instance 

If the authentication fails the application throws an Exception that will be handled by the application filter

If the authentication is succesfull the principal returned is put by the filter on a ThreadLocal so that the authentication can be done only once, also with the help of the
session filter

Session filter > takes the principal and associates it with the user session


Schema
The application can have a file called schema.sql with all the DB schema, that is fired and creates all the DB schema when the appilciation is first fired


If using a different table than some called 'users' we have to make the login query using 2 methods:
userByUsernameQuery and authorotiesByUsernameQuery with some simple select method:
select username, password, enabled from user wheren usernmae = ?
select username, authority from authorities where username = ?






