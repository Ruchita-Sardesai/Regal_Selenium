@HomePage
Feature: Home page feature

@user3
Scenario Outline: Home page feature

//Prequisities
Given User is on the home page
Then Verify user is on the homepage and click on Users
And Verify user is on the Users page


Examples:
    | Email | Password |
    | abhishek@regal-us.com | Abhi@123  |