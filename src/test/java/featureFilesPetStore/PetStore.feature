Scenario: User is able to make a get request
Given
When I enter valid username and valid password
Then The user is able to LogIn
And Closes browser