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
      | password        | Parola123!     |
      | confirmPassword | Parola123!     |
    And privacyCheckBox is clicked
    And Continue button is clicked
    Then the following key words are present within an error message
      | <errorMessage> |
    Examples:
      | affectedField | first name                        | last name   | email              | phone number | errorMessage                                    |
      | Email         | Gloria                            | Calugareanu |                    | 079888677    | appear to be valid!                             |
      | First Name    |                                   | Calugareanu | emailbun@gmail.com | 079888677    | First Name must be between 1 and 32 characters! |
      | Last Name     | Gloria                            |             | emailbun@gmail.com | 079888677    | Last Name must be between 1 and 32 characters!  |
      | Phone         | Gloria                            | Calugareanu | emailbun@gmail.com |              | Telephone must be between 3 and 32 characters!  |
      | Phone         | Gloria                            | Calugareanu | emailbun@gmail.com | 79           | Telephone must be between 3 and 32 characters!  |
      | First Name    | 07izqFNuWZD4CaIlBu09S7Bm8Cp5Bbina | Calugareanu | emailbun@gmail.com | 079888677    | First Name must be between 1 and 32 characters! |