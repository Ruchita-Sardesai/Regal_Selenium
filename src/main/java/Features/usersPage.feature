@Userspage
Feature: Add users

Scenario Outline: Verify user is able to Add user

Given Click on Add users button
Then Enter the Email into the emailbox
Then select the role from the checkbox
Then select the entities
And click on Save button

Examples:
    | Email |
    | abhishek@regal-us.com |

 