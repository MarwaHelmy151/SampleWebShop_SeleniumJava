@Regression  
Feature: User can contact us 
       
    
Scenario Outline: User can contact us successfully


When    User can send enquiry in contact us page <fullname> and <email> and <enquiry>
Then    "Your enquiry has been successfully sent to the store owner." enquiry is successfully sent

Examples:
 |fullname     |email              |  enquiry         |
 |Maria Test  |MariaTest3@gmail.com| This is for test|