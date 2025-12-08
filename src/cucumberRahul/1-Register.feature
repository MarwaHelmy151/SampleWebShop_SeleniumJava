@Regression
Feature: User Registration

Background:
When   User open Register page     
     
Scenario Outline: User can register successfully

Scenario:
And    User can resgister with firstname <firstname> and lastname <lastname> and email <email> and password <password>
Then   "Your registration completed" message is displayed


 Examples:
    |firstname |lastname      |email                 | password|
    |Maria     |Test          |MariaTest83@gmail.com | 123456 |
    

    