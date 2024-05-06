Feature: As a user, I should be able to login

  Background: user go to login page
    Given user is on the home page
    And User navigate to login page

  Scenario Outline: User can login with valid credentials (either clicking on the "Login button" or hitting the
  "Enter" key from the keyboard as the last step)
    Given the user is logged in with "<submitType>"
    Then the user should see the url contains "/account?check_logged_in=1"
    And the user should see the username as "van.sdet01@gmail.com"
    Examples:
      | submitType   |
      | submitButton |
      | enterKey     |
