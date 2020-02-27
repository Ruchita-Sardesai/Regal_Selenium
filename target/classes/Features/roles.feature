@RolePage
Feature: Add Roles


Scenario: Verify user is able to Add role

Given Login for Roles
Then Click on roles button
Then Click on Add role button
Then Add the role name
Then select the role level
Then select the role permissions
Then click on Save button
Then verify Role created succesfully
Then Search the Role in the search box
Then Verify Manage Role
Then Verify Manage Members