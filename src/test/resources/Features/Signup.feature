
@tag
Feature: Signup Functionality

  @positivesignup1
  Scenario: Check if the user is able to click sign up 
    Given The user is in the homepage
    When The user hovers over signup and clicks tamil mass sign up button
    And The user clicks on submit after entering passcode
    Then The user is navigated to the sign up page
    
  @positivesignup2
  Scenario: Check if the user is able to sign up for mass 
    Given The user is in the sign up page
    When The user enters all the details in the sign up page 
    And The user clicks on submit button
    Then The confirmation box for sign up appears in the sign up page  
     
     @positivesignup5
  Scenario: Check if the user is able to click the confirmation box
    Given The user is in the confirmation box window
    When The user clicks ok button
    Then The pop up window with confirm message should appear in the sign up page 
       @positivesignup6
  Scenario: Check if the user is able to click the cancel button in confirmation box
    Given The user is in the confirmation box window
    When The user clicks cancel button
    Then The user is navigated to the sign up page
      @positivesignup7
  Scenario: Check if the user is able to click on success pop up window
    Given The user is in the success pop up window 
    When The user clicks ok button
    Then Signed up successfully message is displayed 
  @positivesignup4
  Scenario: Check if the user is able to click on the email if there is no passcode
    Given The user is in the homepage
    When The user clicks on the coordinators email 
    Then The user is navigated to the email page 
        @positivesignup8
  Scenario: Check if the user is able to click on Back to signup page
     Given The user is in View Guests page
     When The user clicks on Back to sign up page
     Then The user should be navigated back to the sign up page successfully
   @positivesignup9
  Scenario: Check if the user is able to view the details in the view guests page
    Given The user is in the sign up page after signing up already
     When The user clicks on View Guests 
     Then The signed up details should match the entered details
         @positivesignup3
  Scenario: Check if the user is able to click on View Guests
     Given The user is in the sign up page 
     When The user clicks on View Guests 
     Then The user is navigated to the View guests page successfully 
    @negativeesignup1
  Scenario: Check if the user is able to sign up with incorrect passcode
    Given The user is in the homepage
    When The user hovers over signup and clicks tamil mass sign up button
    And The user clicks on submit after entering incorrect passcode
    Then The pop up window with error message is displayed
   

          @negativeesignup2
  Scenario: Check if the user is able to sign up with empty name field
   Given The user is in the sign up page
    When The user enters details in the sign up page leaving the name field unselected
    And The user clicks on submit button
    Then The error message to fill fields is displayed
              @negativeesignup3
  Scenario: Check if the user is able to sign up with empty attend field
   Given The user is in the sign up page
    When The user enters details in the sign up page leaving will you attend field unselected
    And The user clicks on submit button
    Then The error message to fill fields is displayed
           @negativeesignup4
  Scenario: Check if the user is able to sign up with empty family count field
   Given The user is in the sign up page
    When The user enters details in the sign up page leaving family count field unselected
    And The user clicks on submit button
    Then The error message to fill fields is displayed
          @negativeesignup5
  Scenario: Check if the user is able to sign up with empty adult count field
   Given The user is in the sign up page
    When The user enters details in the sign up page leaving adult count field unselected
    And The user clicks on submit button
    Then The error message to fill fields is displayed
                @negativeesignup7
  Scenario: Check if the user is able to sign up with empty kids count field
   Given The user is in the sign up page
    When The user enters details in the sign up page leaving kids count field unselected
    And The user clicks on submit button
    Then The pop up window with should appear in the sign up page
              @negativeesignup8
  Scenario: Check if the user is able to sign up with thanksgiving field empty
   Given The user is in the sign up page
    When The user enters details in the sign up page leaving thanksgiving field empty
    And The user clicks on submit button
    Then The pop up window with should appear in the sign up page
    
        @negativeesignup9
  Scenario: Check if the user is able to sign up with repose of souls field empty
   Given The user is in the sign up page
    When The user enters details in the sign up page leaving repose of souls field empty
    And The user clicks on submit button
    Then The pop up window with should appear in the sign up page
        
        @negativeesignup10
  Scenario: Check if the user is able to sign up with family intention field empty
   Given The user is in the sign up page
    When The user enters details in the sign up page leaving family intention field empty
    And The user clicks on submit button
    Then The pop up window with should appear in the sign up page
    
      @negativeesignup11
  Scenario: Check if the user is able to sign up again
 Given The user is in the sign up page after signing up already
    When The user selects the name in the dropdown
    Then The error message you have already signed up is displayed
    
          #@negativeesignup12
  #Scenario: Check if the user is able to sign up with special characters in the thanksgiving field
   #Given The user is in the sign up page
    #When The user enters all details and special characters in thanksgiving field
    #And The user clicks on submit button
    #Then The error message for special characters should appear in the sign up page
    #
      #@negativeesignup13
  #Scenario: Check if the user is able to sign up with special characters in the repose of souls field
   #Given The user is in the sign up page
    #When The user enters all details and special characters in repose of souls field empty
    #And The user clicks on submit button
    #Then The error message for special characters should appear in the sign up page
    #@negativeesignup14
  #Scenario: Check if the user is able to sign up with special characters in the family intentions field
   #Given The user is in the sign up page
    #When The user enters all details and special characters in family intentions field empty
    #And The user clicks on submit button
    #Then The error message for special characters should appear in the sign up page
    
    