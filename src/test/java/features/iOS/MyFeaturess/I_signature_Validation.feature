Feature: signature validation

  @ios @chrome
  Scenario Outline:  To validate if user can use signature
    Given user click on checkIn menu
    And select login using name
    And user enter "<firstName>" and "<lastName>"
    And click on continue button
    And select email proceed for departure
    And validate after entering OTP for emailAddress
    And select reservation
    Then validate signature after click on continue button

    Examples:
      | lastName |firstName |
      | kumar    |  balram  |


