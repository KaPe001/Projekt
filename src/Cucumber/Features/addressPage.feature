Feature: LogIn to an account

  Scenario Outline: User wants to log in to an account
    Given Open the website https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account
    When email and password were entered
    When enter address information
    And First write an <alias>
    And Then write your <address>
    And Then make up the <zipCode>
    And What <city> you live in
    And What is your country
    And Can i have you <phone> number
    Then confirm entered data
    And delete the address

    Examples:
      | alias |     address     | zipCode |   city   |    phone     |
      | Ms.   |  Gieldowa 137   | 93-348  |   Lodz   | 53 109 70 23 |