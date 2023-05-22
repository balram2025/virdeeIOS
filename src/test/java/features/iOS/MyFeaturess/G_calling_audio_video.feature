Feature:  verify if calling functionality is working

  @ios
  Scenario: verify if calling functionality is working
    When user select want to talk someone link
    And select Video call option
    And user end the Video call
    Then user should see video call option
    And select audio call option
    And user end the audio call
    Then user should see audio call option