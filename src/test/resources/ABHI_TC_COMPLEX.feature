Feature: As a admin, admin want to assign different groups to different users and member group message should get dispalyed

@tag1
Scenario: To verify whether application allows admin to provide different access to different registered users
Given Admin log in 
And enters <name>,<group>,<comment> at "E:\Selenium triang\Cucumber BDD\Complex\TestData.xlsx".
