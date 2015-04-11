Narrative:
In order to search into flipkart site
As a Test team
I want to login into flipkart and check the search and view item functionality

Scenario: Search for items in flipkart

Given searchresults test is initialised
Given The browser <browsertype> is opened
Then User opens the <URL>
Then the user logs into the system with the <username> and <password>
Then user searhces for <searchvalue>
Then selects an item from the search results
And View the item
Then user ends the test case and closed the browser


Examples:
|browsertype|URL|username|password|searchvalue|
|Chrome|http://www.flipkart.com/|naveenkv20@gmail.com|test123|timex watch|