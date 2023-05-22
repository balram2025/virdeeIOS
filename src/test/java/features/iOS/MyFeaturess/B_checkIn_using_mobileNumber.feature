Feature: check-In using Mobile Number

  @ios @chrome
  Scenario Outline: To validate If user can checkIn using Mobile number
    Given user click on checkIn menu
    When user select login using mobile number
    And  click on continue after entering valid "<mobileNumber>"
    And validate it after entering OTP for mobile number "<mobileNumberForOTP>"
    And validate after entering OTP for
    And navigate back to home screen

    Examples:
    | mobileNumber | mobileNumberForOTP |
    | 19794293446 |  9794293446         |


