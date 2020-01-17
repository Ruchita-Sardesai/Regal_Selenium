@Regression
Feature: Org Admin Login feature


@Regression
Scenario Outline: Org admin login Scenario

//Prequisities
Given User should open the browser
When Title of login page matches
Then User Enters the "<Email>" and "<Password>"
And User clicks on login button
And Verify user is on Home Page
Then Close the browser

Examples:
    | Email | Password |
    | abhishek@regal-us.com | Abhi@123    |
   

@Regression
Scenario Outline: Org admin login with invalid credentials

//Prequisities
Given User should open the browser
When Title of login page matches
Then User Enters the "<Email>" and "<Password>"
And User clicks on login button
And Verify Invalid UserName and credentials error message
Then Close the browser

Examples:
| Email | Password |
| chethan@regal-us.com |Chethan@123|