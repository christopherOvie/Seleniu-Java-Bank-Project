Feature: login for old user

  Background: 
    Given open "chrome" browser
    When launch site

  Scenario Outline: login page positive test
    And fill fields with "<un>" and "<pwd>"
    And click on sign in and agree to private policy
    Then "Welcome!" msg should be displayed in account page
    Then title should contain "UiBank"
    And I click on apply for a loan on loans page
    Then title should contain "UiBank"
    And fill fields with "<email>" ,"<loanAmount>" ,"<loanTerm>", "<currentYearlyIncome>" and "<age>"
    When I click on submit loan application

    Examples: 
      | un                    | pwd          | email                 | loanAmount | loanTerm | currentYearlyIncome | age |
      | gcreddy1997@gmail.com | Madhavi@1206 | gcreddy1997@gmail.com |      12300 |   100000 |              200000 |   5 |

  Scenario Outline: Error handling test or fuzzing test for wrong data in registration form
    And fill fields with "<un>" and "<pwd>"
    And click on sign in and agree to private policy
    Then "Welcome!" msg should be displayed in account page
    Then title should contain "UiBank"
    And I click on apply for a loan on loans page
    Then title should contain "UiBank"
    And fill fields with "<email>" ,"<loanAmount>" ,"<loanTerm>", "<currentYearlyIncome>" and "<age>"
    When I click on submit loan application
    Then related msg should be displayed as per "<criteria>"

    Examples: 
      | un                    | pwd          | email                 | loanAmount | loanTerm | currentYearlyIncome | age | criteria         |
      | gcreddy1997@gmail.com | Madhavi@1206 |                       |       1000 |        1 |                1000 |  21 | email_blank      |
      | gcreddy1997@gmail.com | Madhavi@1206 | gcreddy1997@gmail.com |            |        3 |                1000 |  21 | loanAmount_blank |
      | gcreddy1997@gmail.com | Madhavi@1206 | gcreddy1997@gmail.com |       1000 |          |                1000 |  21 | loanTerm_blank   |
      #| gcreddy1997@gmail.com | Madhavi@1206 | gcreddy1997@gmail.com |       5000 |        5 |                     |  20 | currentYearlyIncome_blank |
      #| gcreddy1997@gmail.com | Madhavi@1206 | gcreddy1997@gmail.com |       5000 |       10 |             9089766 |     | age_blank                 |
      #| gcreddy1997@gmail.com | Madhavi@1206 | gmal.com6zz           |       5000 |       10 |               10000 |  32 | email_wrongemailformat    |
      #| gcreddy1997@gmail.com | Madhavi@1206 | gcreddy1997@gmail.com |      10000 |       13 |                 100 |  21 | loanTerm_wrongsize        |
      #| gcreddy1997@gmail.com | Madhavi@1206 | gcreddy1997@gmail.com |      23344 |        1 |               10000 |   8 | age_wrong                 |
