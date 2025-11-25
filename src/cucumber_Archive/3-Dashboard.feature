@Regression  
Feature: User can order product  
       
    
Scenario Outline: User can order product successfully
Given   User open login page
When    User enter valid email and password
And     User can add product to cart
And     User can checkout
Then    Order is successfully processed