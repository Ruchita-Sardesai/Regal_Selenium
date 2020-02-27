@usersPage
Feature: Add users feature



Scenario: Add user 

//Prequisities
Given Launch browser and login
Then Click on Add users button
And Enter the email and select the role and entity 
And verify user created succesfully
And Search the user in the search box and select the manage user by clickin on ellipsis icon
Then Click on manage user
Then Click on Resend_Invite
Then Click on Remove user
Then verify user removed succesfully










 