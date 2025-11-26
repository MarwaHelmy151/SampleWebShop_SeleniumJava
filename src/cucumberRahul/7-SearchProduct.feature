@Regression  
Feature: User can search for a product 
       
    
Scenario Outline: User can search for a product

When   User open login page
When    User enter valid email <email> and password <password>
And     User can search for a product <desiredProduct> and enter <recipientName> and <recipientemail>
Then    "The product has been added to your shopping cart" successMessage product added to cart


Examples:
 |email                 | password|desiredProduct        |recipientName |recipientemail |
 |MariaTest3@gmail.com  | 123456  |$25 Virtual Gift Card |Gift card     |Giftcard@gmail.com |