Feature: validate setting section

  @ios
  Scenario Outline: To validate If user can validate setting section
    Given user click on checkIn menu
    When user select setting icon
    And user enter "<password>" and submit it


    Examples:
      | password |
      | 7463     |