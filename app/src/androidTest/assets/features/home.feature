Feature: Home
  # Tests for the home

  # Home activity contain 3 tabs
  Scenario: User should see home when opened the app
    Given The app started
    Then I see home screen
