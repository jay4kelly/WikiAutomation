Feature: Purchasing From Each Category in the Store
	Purchase Womens products using different techniques
  
Background: User is home page
	Given User is on "home_page" site 
	
Scenario Outline: Purchase products, select currency and check out 
	Given User has added <Product> of <Size> and <Quanity> to cart 
	And User is on "cart_page" site
	Then User selects currency <Currency> value
	And Completes Check out 
	Examples: 
		|Product				|Size	|Quanity	|Currency		|
		|Globe hoodie (women)	|Large	|2			|AUD			|
		|Wikipedia rabbit hole t-shirt (women)	|Large	|2			|CAD			|
		|Wikipedia rabbit hole t-shirt (women)	|Large	|2			|RUB			|
	