@Regression  
Feature: User can send Email  
       
    
Scenario Outline: User can send Email to Friend successfully

When   User open login page
When   User enter valid email <email> and password <password>
And    User can select productcategory <productcategory> from topmenu 
And    User can select desired product <desiredproduct> and send Email to friend
Then   "Your message has been sent." mail is successfully sent

Examples:
 |email                 | password|productcategory|desiredproduct|
 |MariaTest3@gmail.com  | 123456  |Apparel & Shoes|Blue Jeans    |
 
 
