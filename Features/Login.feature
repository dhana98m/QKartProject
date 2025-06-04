Feature: Login functionality

Scenario: Login with credentials
          Given user Launch the Browser
          When user Launch the application by passing the URL "https://crio-qkart-frontend-qa.vercel.app/"
          Then user clicks on login button
          And user enters username as "admin123"
          And user enter password as "admin123"
          And user clicks on login to QKart
          Then user should see the "LOGOUT" button 