Feature: Add items to Cart and check out process

Scenario: Add item to cart, validate messages, add another item, checkout, add and delete address
          Given user Launch the Browser
          When user Launch the application by passing the URL "https://crio-qkart-frontend-qa.vercel.app/"
          Then user clicks on login button
          And user enters username as "admin123"
          And user enter password as "admin123"
          And user clicks on login to QKart
          And user adds "YONEX Smash Badminton Racquet" item to cart
          Then user clicks add to cart again for "YONEX Smash Badminton Racquet" and validates the message "Item already in cart. Use the cart sidebar to update quantity or remove item."
          And user adds "Roadster Mens Running Shoes" and select size "7" from the dropdown 
          Then user validates the cart items "YONEX Smash Badminton Racquet","Roadster Mens Running Shoes"
          And user clicks on checkout button
          And user verifies that the page title is "QKart"
          And user clicks on add new address and enters address "No.2,Jothi street,xyz nagar"
          And user clicks on ADD button and verifies the address "No.2,Jothi street,xyz nagar" entered is displayed
          And user clicks on DELETE button to remove an address "adrs1 adrs 2adr3 adre3"
          

         

       

          
