@RolePage
Feature: Add Roles

@user3
Scenario Outline: Verify user is able to Add role

Given Click on roles button
Then Click on Add role button
Then Add the role name
Then select the role level
Then select the role permissions
And click on Save button



Examples:
    | Email |
    | abhishek@regal-us.com |

 