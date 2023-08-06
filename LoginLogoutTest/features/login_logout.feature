Feature: Login on practicetestautomation website
  
 Scenario: Valid Credentials - Successful Login
	Given the user is on the login page
	When the user enters valid Username and Password
	And the user clicks on the Login button
	Then the user should be redirected to the homepage
	And the message "Logged In Successfully" should be displayed on the homepage
	
	Scenario: Successful Logout
	Given the user is on the homepage page
	When the user clicks on the Logout button
	Then the user should be redirected to the login page
	
 Scenario: Invalid Credentials - Unsuccessful Login
	Given the user is on the login page
	When the user enters invalid Username Password
	And the user clicks on the Login button
	Then the message "Your username is invalid!" should be displayed
	
	Scenario: Unsuccessful Logout
	Given the user is on the homepage page
	When the user clicks on the Home menu
	Then the user unable to logout successfully and should be redirected to the homepage