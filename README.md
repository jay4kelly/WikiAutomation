# WikiAutomation
Automated testing of WikiStore site using selenium, testNG and cucumber

## Objective
Demonstrate use of the following testing technologies and procedures as part of providing a complete testing framework.

- Selenium (All web page access)
- TestNG (Regression Testing)
- Cucumber (Acceptance Testing)
- Page Object Design (shared between TestNG and Cucumber)
- Maven (build and test)
- Log4J2 (logging)
- CircleCI (continuous build integration) TBD

## WikiStore Web Site to be tested

[WikiStore URL]: https://store.wikimedia.org

[<img src="https://github.com/jay4kelly/WikiAutomation/resources/blob/master/WikiStoreSite.PNG">](https://github.com/)

## Page Object Design

Page Object model is an object design pattern in Selenium. Web pages are represented as classes, and elements on the page are defined as variables on the class, so user interactions can then be implemented as methods on the class.

FindBy annotation are used to reference the WebElements


## TestNG

TestNG framework is an open source automated testing framework and here NG means Next Generation. TestNG is quite similar to JUnit. TestNG is inspired by the JUnit framework and it is designed in such a way that it turns out better than JUnit, when testing the integrated classes. TestNG has been created by Cedric Beust. 

TestNG is used for regression testing in this project.

Test Classes

- ValidateHomePage (in progress
- ValidateProductDetailsPage (TBD)
- ValidateCartPage (TBD)
- ValidateWomenPage (TBD)
- ValidateMenPage (TBD)
- ValidateKidsPage (TBD)
- ValidateAccessoriesPage (TBD)
- ValidateWiki15Page (TBD)


## Cucumber

Cucumber is a software tool that supports behavior-driven development. Central to the Cucumber BDD approach is its ordinary language parser called Gherkin. It allows expected software behaviors to be specified in a logical language that customers can understand.

Cucumber is used to perform Acceptance testing in this project.

Features

- Purchase.feature  (in progress)
- Cart.feature (TBD

## Logging

Apache Log4j is a Java-based logging utility. It was originally written by Ceki Gülcü and is part of the Apache Logging Services project of the Apache Software Foundation.

Log4J2 generates a log file named prints.log in the project's logs directory.
Logs are written to generate info level details as well as for exceptions.

