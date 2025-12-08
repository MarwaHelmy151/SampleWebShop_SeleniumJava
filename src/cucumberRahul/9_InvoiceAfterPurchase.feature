@Regression  
Feature: User can order product and get invoice after purchase  
       
Background:
When   User open login page
    
Scenario Outline: User can download invoice after Purchase

When   User enter valid email <email> and password <password>
And    User can select product <productcategory> and <item> from list and select <desiredproduct>
And    User can add desired product <desiredproduct> to cart
And    User can select another category <productcategory2> and add item <desiredproduct2>
Then   User can download invoice after purchase


Examples:
 |email                 | password|productcategory|item          | desiredproduct     |productcategory2|desiredproduct2| 
 |MariaTest3@gmail.com  | 123456  |Computers      |Notebooks     | 14.1-inch Laptop   |Apparel & Shoes |Casual Golf Belt| 