@LectieAvansata
Feature: Registration flow feature

  Background:
    Given "HomePage" is accessed

  @ExecutaAcestTC
  Scenario: The Registration page can be accessed from navigation bar
    When user clicks on register buttons from navigation bar
    Then Correct "RegisterPage" endpoint is displayed


  Scenario: Open cart page is accessible
    Then "https://demo-opencart.com/" is present within the current url

  @LectieAvansata
  Scenario Outline: error message is displayed when providing invalid data for <affectedFiled>
    Given "RegisterPage" is accessed
    When the register fields are populated with the following data:
      | firstName       | <first name>   |
      | lastName        | <last name>    |
      | email           | <email>        |
      | phoneNumber     | <phone number> |
      | password        | parola123      |
      | confirmPassword | parola123      |
    And privacyCheckBox is clicked
    And  continue button is clicked
    Then the following key word are present within an error message
      | <errorMessage> |
    Examples:
      | affectedField | first name                       | last name   | email                        | phone number | errorMessage                                   |
      | Email         | Gloria                           | Calugareanu |                              | 0899988877   | appear to be valid                             |
      | First Name    |                                  | Calugareanu | calugareanu.gloria@gmail.com | 0899988877   | First name must be between 1 and 32 characters |
      | Last Name     | Gloria                           |             | calugareanu.gloria@gmail.com | 0899988877   | Lat name must be between 1 and 32 characters   |
      | Phone         | Gloria                           | Calugareanu | calugareanu.gloria@gmail.com |              | Telephone must be between 3 and 32 characters  |
      | Phone         | Gloria                           | Calugareanu | calugareanu.gloria@gmail.com | 79           | Telephone must be between 3 and 32 characters  |
      | First Name    | qse4fTghy65fvbnhytfvder56hgbvcdf | Calugareanu | calugareanu.gloria@gmail.com | 2432423423   | Telephone must be between 3 and 32 characters  |
