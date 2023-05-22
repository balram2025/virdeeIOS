Feature: edit user

  @ios @chrome
  Scenario Outline:  To validate if user can edit
    Given user click on checkIn menu
    And select login using name
    And user enter "<firstName>" and "<lastName>"
    And click on continue button
    And select email proceed for departure
    And validate after entering OTP for emailAddress
    And select reservation
    And select edit user details
    And edit "<newLastName>" and update details "<lastName>"


    Examples:
      | firstName | lastName | newLastName |
      | balram    | Kumar    | k           |
