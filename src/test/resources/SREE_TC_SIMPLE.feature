Feature: As a customer(Unregistered User), I want to create login credentials so that  I can securely access my self-service online account.
@tag1
Scenario: Unregistered User should receive confirmation message on signup
Given  as an unregistered user
When I fill out the signup form
And click submit
Then I should receive a confirmation message stating:"Thanks for registering!Your account has been created and needs to be activated by the administration"  .