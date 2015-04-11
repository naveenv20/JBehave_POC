Narrative:
In order to check the customer care page
As a Test team
I want to login into flipkart and needs to navigate to customer care page and check

Scenario: customer care page checks

Given customercarecheck test is initialised
Given The browser <browsertype> is opened
Then User opens the <URL>
Then user clicks on the customercare link
Then user select the case as <case_type>
Then user selects the <question_number> and checks the question text as <Question_text>
Then user ends the test case and closed the browser

Examples:
|browsertype|URL|case_type|question_number|Question_text|
|Firefox|http://www.flipkart.com/|Offer Redemption|4|I haven't yet received my Cashback|
|Firefox|http://www.flipkart.com/|Offer Redemption|2|I haven't yet received my Cashback|