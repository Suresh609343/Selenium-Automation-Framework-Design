@tag
Feature: Purchase the Order form Ecommerece Website
  I want to use this template for my feature file

	Background: 
	Given I Landed on Ecommerce Page
	
	
  @Regression
  Scenario Outline: Positive Test of Submitting the Order
  
    Given Login with username <name> and password <password>
    When Add Product <productname> to cart
    And Verify the Product <productname> and go to checkout Page and place the Order
    Then "THANKYOU FOR THE ORDER." message is displayed on the Confirmation Page

    Examples: 
      | name                  | password   | productname     |
      | sureshkumar@gmail.com | 6093430Sm* | IPHONE 13 PRO   |
      | skmgralanja@gmail.com | 6093430Sm* | ADIDAS ORIGINAL |
