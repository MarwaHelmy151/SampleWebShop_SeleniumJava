@Regression  
Feature: User can add a product to wishlist  
       
    
Scenario Outline: User can add product to wishlist successfully

When   User open login page
When    User enter valid email <email> and password <password>
And     User can select productcategory <productcategory> from topmenu 
And     User can select desired product <desiredproduct> and add it to wishlist
Then    "The product has been added to your wishlist" product is successfully added

Examples:
 |email                 | password|productcategory|desiredproduct|
 |MariaTest3@gmail.com  | 123456  |Jewelry         |Black & White Diamond Heart   |