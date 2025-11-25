@Regression  
Feature: User Login
       
    
Scenario Outline: User can login successfully

Given   User open login page
When    User enter valid email and password
Then    User can login successfully 