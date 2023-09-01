Feature: Customer 


Background: Commont steps for all scenarios
		Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
  	Then User can view the Dashboard

	@Sanity @three
	Scenario: Add  new customer 
  	
  	When User clicks on Customer button
  	And  Click on Customer sub menu button
  	And Click on Add new button
  	Then User can view add new customer page
  	When User enter  customer info
  	And click on save button
  	Then User can view confirmation messages " The new customer has been added sucessfully."
  	And close browser 
  	
  	@regression @four
  	Scenario: Search Customer by Email 
  	
  	When User clicks on Customer button
  	And  Click on Customer sub menu button
  	And  Enter Customer Email
  	When click on search button
  	And close browser
  	
  	