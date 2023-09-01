Feature: Login
	@Sanity @regression @one
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be After Logout "Your store. Login"
    And close browser



    @regression @two
   Scenario Outline: Successful Login with Valid Credential DDT
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be After Logout "Your store. Login"
    And close browser
    Examples:
    |email                       |password|
    |admin@yourstore.com				 |admin|
    |admin@yourstore.com				 |admin|  
    
    
    