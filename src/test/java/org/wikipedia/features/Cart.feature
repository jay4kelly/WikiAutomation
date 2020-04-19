Feature: Validate Cart Management actions
	Users can add, remove and update cart.
  
Background: User is home page
	Given User is on "home_page" site 
	
Scenario: Add, remove and update items 
	Given Cart is empty
	And User performs the following purchases and cart actions
	|Action	| Product				| Size	| Quantity |
	| Add	| Globe hoodie (women)	| Large | 3		   |
	| UpdateSize |	Globe hoodie (women) | Small	|		|
	| UpdateQuantity	|	Globe hoodie (women) 	| 	|	1	|
	Then User should have the following left in cart
	|Product				|	Size	|	Quantity	|
	| Globe hoodie (women)	| Small		|	1			|
 
