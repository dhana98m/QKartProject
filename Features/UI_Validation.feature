Feature: Validation of UI Elements
            
Scenario: Validate Login Button, Register Button, Search Text Box
          Given user Launch the Browser
          When user Launch the application by passing the URL "https://crio-qkart-frontend-qa.vercel.app/"
          Then user should see the "LOGIN" button and it should be clickable
          Then user should see the "REGISTER" button and it should be clickable
          Then user should see the search text box and it should be enabled