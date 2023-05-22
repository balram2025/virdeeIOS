Feature: check-In using Email Address

  @ios
  Scenario: To validate If user can checkIn using Mobile number
    Given user click on checkIn menu
    When user select login using QR Code
    Then wait for scanning
