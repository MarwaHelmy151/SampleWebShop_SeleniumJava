@Regression  
Feature: User Login
       
    
Scenario Outline: User can login successfully

When   User open login page
And    User enter valid email <email> and password <password>
Then   User can login successfully and customerinfo <email> is found


Examples:
 |email                 | password|
 |MariaTest3@gmail.com | 123456  |