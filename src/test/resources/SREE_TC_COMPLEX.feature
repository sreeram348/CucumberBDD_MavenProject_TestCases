Feature: As a customer(Unregistered User), I want to create login credentials using excel sheet so that  I can securely access my self-service online account .
@tag1
Scenario:  Users should receive confirmation message on signup using excel Sheet
Given   Registration Page
When Enter Details <Login name>,<Full name>,<E-Mail>	,<Gender>,<Address>,<Postal Code>,<City>,<Phone>,<Mobile phone>,<Fax>,<Url>,<Password>	and <Confirm password> at"E:\Selenium triang\Cucumber BDD\Complex\TestData.xlsx".


            