@smoketest @realtest
Feature: login for old user

  Background: 
    Given open "chrome" browser
    When launch site

  Scenario Outline: login page positive test
    And fill fields with "<un>" and "<pwd>"
    And click on sign in and agree to private policy
    Then "Welcome!" msg should be displayed in account page
    Then title should contain "UiBank"
      And close site

    #Then close site
    Examples: 
      | un                    | pwd          |
      | gcreddy1997@gmail.com | Madhavi@1206 |
      | chris                 | Test123      |
