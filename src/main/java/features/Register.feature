Feature: Registration flow feature
@ExecutaAcestTC

  Scenario: The Registration page can be accessed from navigation bar
    Given "https://demo-opencart.com/" is accessed
    When user clicks on register buttons from navigation bar
    Then "https://demo-opencart.com/" is present within the current url

  Scenario: Open cart page is accessible
    When "https://demo-opencart.com/" is accessed
    Then "https://demo-opencart.com/" is present within the current url
