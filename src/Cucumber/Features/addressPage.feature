Feature: LogIn to an account

  Scenario Outline: User wants to log in to an account
    Given Open the website https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account
    When email and password were entered
    When enter address information
    And First write an <alias>
    And Then write your <address>
    And Then make up the <zipCode>
    And What <city> you live in
    And What is your <country>
    And Can i have you <phone> number
    And close the browser

    Examples:
      | alias |     address     | zipCode |   city   |    country     |    phone     |
      | Ms.   |  Giełdowa 137   | 93-348  |   Lodz   | United Kingdom | 53 109 70 23 |
      | Ms.   |  Zakątna 88     | 03-184  | Warszawa | United Kingdom | 69 547 79 93 |
      | Ms.   |  Czereśniowa 65 | 31-410  | Krakow   | United Kingdom | 78 629 25 57 |