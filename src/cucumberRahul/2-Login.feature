@Regression  
Feature: User Login
       
Background:
When   User open login page
    
Scenario Outline: User can login successfully

Scenario: Successful login
And    User enter valid email <email> and password <password>
Then   User can login successfully and customerinfo <email> is found


Examples:
 |email                 | password|
 |MariaTest3@gmail.com  | 123456  |
 
 
 
 Scenario: Failed login due to incorrect password
 And   user enters incorrect email <email> and password <password>
 Then  user should see an error message "The credentials provided are incorrect"
    
Examples:
 |email                 | password|
 |MariaTest3@gmail.com  | xxxx    |   
    
 
    
 Scenario: Failed login due to empty fields
 And   user leaves the username and password fields empty
 Then  user should see a validation message "No customer account found"