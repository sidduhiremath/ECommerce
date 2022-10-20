@mCheck
Feature: Search an Item

Scenario: Personal Informaion Update
Given User clicks on My Personal Information button
And User Selects Social title Option #Radio button
And User Updates Date of Birth #Data picker
Then User enters Password
And Clicks on Save button


Scenario: Search An Item
Given User Clicks on Search bar
When User enters Item name
And Clicks on Search icon
And User Filters the product#DropDown

Scenario: Check Availability  of item
Given User Fetches the availability of product
And User Verifies the Item Availability

