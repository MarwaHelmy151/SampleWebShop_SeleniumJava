@Regression  
Feature: User can change password 
       
    
Scenario Outline: User can change password successfully 

When   User open login page
When   User enter valid email <email> and password <password>
And    User can navigate to customer info page and change password <password> and <newpassword>
Then   "Password was changed" message appears
And    User can log in with <email> and <newpassword>


Examples:
 |email                  | password| newpassword |
 |MariaTest29@gmail.com  | 123456  | 12345678    |