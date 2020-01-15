@RolePage
Feature: Add Roles

Scenario Outline: Verify user is able to Add role

Given Click on roles button
Then Click on Add role button
Then Add the role name
Then select the role level
Then select the role permissions
And click on Save button

//Prequisities
Given User is on the home page
Then Verify user is on the homepage and click on Users
And Verify user is on the Users page

Examples:
    | Email |
    | abhishek@regal-us.com |

 