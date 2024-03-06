@smoketest @realtest
Feature: login for old user

  Scenario Outline: Data table data along with examples data
    Given open "<bn>" browser
    When launch site
    And do successful login by giving valid data in "<bn>"
      | un                    | pwd          |
      | gcreddy1997@gmail.com | Madhavi@1206 |
      #| chris                 | Test123      |
      And click on sign in and agree to private policy
      Then "Welcome!" msg should be displayed in account page
    And close site

    Examples: 
      | bn      |
      | chrome  |
      | firefox |
      | edge    |
