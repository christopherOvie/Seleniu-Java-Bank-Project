
Feature: login page

  Background: 
    Given open "chrome" browser
    When launch site

  @smoketest @realtest
  Scenario: login page title test
    Then title should contain "UiBank"
    When close site

  @smoketest @realtest
  Scenario: login page fields test
    Then page should be contain required fileds
    When close site
