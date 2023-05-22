Feature: check-In using departure date

  @ios @chrome
  Scenario Outline: To validate If user can checkIn using name and departure date
    Given user click on checkIn menu
    When select using name and departure date
    And enter valid "<firstName>" and "<lastName>"
    And select departure date "<departureDate>"
    And select email proceed for departure
    And  click on continue after entering valid emailAddress "<emailAddress>"
    And validate after entering OTP
    And navigate back to home screens
    Examples:
      | firstName | lastName | departureDate      | emailAddress                 |
      | balram    | kumar    | Wednesday, 29 March | balram_virdee@mailinator.com |