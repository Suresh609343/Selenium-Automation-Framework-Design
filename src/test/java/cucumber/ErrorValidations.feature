
@tag
Feature: Checking for Login Error Validation and Product in Cart Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Error Validation for Login
  
  	Given I Landed on Ecommerce Page
    Given Login with username <name> and password <password> 
    Then I verify the message "Incorrect email or password."

    Examples: 
      | name                  | password    |
      | sureshkumar@gmail.com | 6093430Ssm* |
