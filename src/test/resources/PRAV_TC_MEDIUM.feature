Feature: As a admin, I want to provide full member access to the user, so that user will be able to access full member home page

@tag1
Scenario: Admin should provide the access to the registered user
Given User
When User completes his registration 
And click on Submit button and logs out
Then Admin will provide access to the registered user

