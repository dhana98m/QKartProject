Feature: Verify the page attributes
         
Scenario: Verify the place holder text,page title,url
          Given user Launch the Browser
          When user Launch the application by passing the URL "https://crio-qkart-frontend-qa.vercel.app/"
          Then user should see the place holder text "Search for items/categories" in search box
          And the page title should be "QKart"
          And the url should starts with "https"
