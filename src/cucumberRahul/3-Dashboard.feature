@Regression  
Feature: User can order product  
       
    
Scenario Outline: User can order product successfully

When   User open login page
When    User enter valid email <email> and password <password>
And     User can select product <productcategory> 
And     User can add desired product <desiredproduct> to cart
And     User can checkout
Then    "Your order has been successfully processed!" order is processed

Examples:
 |email                 | password|productcategory|desiredproduct|
 |MariaTest3@gmail.com  | 123456  |Cell phones    |Smartphone    |