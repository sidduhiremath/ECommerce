Feature: Login to Application
@Login
Scenario: Login to the E-Commarce Appication
Given User Navigate to Application
When User clicks on Signin Option
And User enters Email and Password
And User clicks on Signin button
Then User Logged into the application Successfully #validate page title


@Logout
Scenario: Logout from the E-Commarce Appication
Given User is in Order Page #validate Order page title
When User clicks on SignOut Option
Then User Logged out from the application Successfully #validate page title