
@Overviewpage
Feature: Check Overviewpage
 
  Scenario: Verify Overview page
  
    Given Login for overview page
    Then Verify user is on the Overview page
    Then Update Organization Details
    Then Verify Overviewpage has list of Orgdmin
    Then Verify Overviewpage has list of Services

