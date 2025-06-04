Feature: Count images and links 
            
Scenario: Verify the images and links count in home page
          Given user Launch the Browser
          When user Launch the application by passing the URL "https://crio-qkart-frontend-qa.vercel.app/"
          Then user should see the images count 14
          And user should see the links count 4