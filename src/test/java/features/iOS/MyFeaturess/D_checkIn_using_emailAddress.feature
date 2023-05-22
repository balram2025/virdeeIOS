Feature: check-In using Email Address

  @ios @chrome
  Scenario Outline: To validate If user can checkIn using Mobile number
    Given user click on checkIn menu
    When user select login using email address
    And  click on continue after entering valid emailAddress "<emailAddress>"
    And validate after entering OTP
#    And navigate back to home screen

    Examples:
      | emailAddress |
      | balram_virdee@mailinator.com |
