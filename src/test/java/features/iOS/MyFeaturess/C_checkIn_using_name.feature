Feature: Check-In using name

  @ios @chrome
  Scenario Outline: Create an account using valid credentials
    Given user click on checkIn menu
    And select login using name
    And user enter "<firstName>" and "<lastName>"
    And click on continue button
    And select email proceed for departure
    And  click on continue after entering valid emailAddress "<emailAddress>"
    And validate after entering OTP
#    And navigate back to home screen
#    Then user should be able to tap on phone number displayed on screen
#    And  click on continue after entering valid "<mobileNumber>"
#    And validate after entering OTP
#    And navigate back to home screen

    Examples:
      | firstName | lastName | mobileNumber | emailAddress                 |
      | BALRAM    | KUMAR    | 918109003069 | balram_virdee@mailinator.com |
