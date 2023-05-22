Feature: checkIn using confirmation Number

  @ios
  Scenario Outline: To verify if user can checkIn using confirmation Number
    Given user click on checkIn menu
    When user select login using confirmation number
    And click on continue after entering valid  confirmation number "<confirmationNumber>"
    And user should be able to tap on phone number displayed on screen
#    And  click on continue after entering valid "<mobileNumber>"

#    And navigate back to home screen

    Examples:
      | confirmationNumber | lastName | mobileNumber |
      | 4MJ676VRD_D        | kumar    | 918319404520 |

