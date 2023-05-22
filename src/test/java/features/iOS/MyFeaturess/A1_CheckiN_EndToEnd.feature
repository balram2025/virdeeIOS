Feature: checkIn end to end

  @ios @chrome
  Scenario Outline: To verify if user can checkIn using all ways
## Name
    Given user click on checkIn menu
    And select login using name
    And user enter "<firstName>" and "<lastName>"
    And click on continue button
    And select email proceed for departure
    And validate after entering OTP for emailAddress
    And navigate to get card and end session

# Name with signature

#    Given user click on checkIn menu
#    And select login using name
#    And user enter "<firstName>" and "<lastName>"
#    And click on continue button
#    And select email proceed for departure
#    And validate after entering OTP for emailAddress
#    And select reservation
#    Then validate signature after click on continue button

#  Phone Number
    And user click on checkIn menu
    When user select login using mobile number
    And  click on continue after entering valid "<mobileNumber>"
    And validate it after entering OTP for mobile number "<mobileNumberForOTP>"
    And validate after entering OTP for
    And navigate to get card and end session

#  Email

    And user click on checkIn menu
    When user select login using email address
    And  click on continue after entering valid emailAddress "<emailAddress>"
    And validate after entering OTP for emailAddress
    And navigate to get card and end session

#  QR

    And user click on checkIn menu
    When user select login using QR Code
    Then wait for scanning
    And navigate back After scanning QR code

#  name and departure date

#    When select using name and departure date
#    And enter valid "<firstName>" and "<lastName>"
#    And select departure date "<departureDate>"
#    And select email proceed for departure
#    And  click on continue after entering valid emailAddress "<emailAddress>"
#    And validate after entering OTP
#    And navigate back to home screen

#   confirmation number

    And user click on checkIn menu
    When user select login using confirmation number
    And click on continue after entering valid  confirmation number "<confirmationNumber>"  and "<lastName>"
    And select email proceed for departure
    And  click on continue after entering valid emailAddress "<emailAddress>"
    And validate after entering OTP for emailAddress
    And navigate to get card and end session

#  Want to talk to someone 24*7

    When user select want to talk someone link
    And select Video call option
    And user end the Video call
    Then user should see video call option
    And select audio call option
    And user end the audio call
    Then user should see audio call option

#    Setting

    When user select setting icon
    And user enter "<password>" and submit it

    Examples:
      | confirmationNumber | lastName | mobileNumber | firstName | departureDate     | emailAddress                 | mobileNumberForOTP | password |
      | 4X73W9VRD_D        | kumar    | 19794293446  | balram    | Thursday, 6 April | balram_virdee@mailinator.com | 9794293446         | 7463     |