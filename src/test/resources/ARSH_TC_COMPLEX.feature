Feature: As a user, I want to register for the application reading values from excel sheet, so that i can access application securely.
@tag
Scenario: To verify whether application allows multiple users to get registered upon entering valid details in the required fields
Given Registration page
When  Enters <Login name>,<Full name>,<E-Mail>	,<Gender>,<Address>,<Postal Code>,<City>,<Phone>,<Mobile phone>,<Fax>,<Url>,<Password>	and <Confirm password> at"E:\Selenium triang\Cucumber BDD\Complex\TestData.xlsx".

