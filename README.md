Information about product:

Test management platform qase.io it is used to create test projects, test cases and tools in them

Checklist:

Login:

- enter to account (with correct email and password)
- exit from account (logout)
- negative login (try to open account with incorrect password or username

Projects:

- creating a new project
- getting created project

Suites:

- creating a new suite

Test cases:

- creating a new test case

Defects:

- creating a new defect
- deleting created defect

Configurations:

- creating a new configuration

Environments:

- creating new environments with different values

Milestones:

- creating a new milestone

Shared Steps:

- creating a new shared step
- try to create new shared step without required values

Used in project:

- Java JDK: 19
- Maven version: 3.0.0-M5
- Allure version: 2.18.0
- selenide version: 5.24.2
- testNG version: 7.6.1
- allure-testng version: 2.18.1
- lombok version: 1.18.24
- log4j-core version: 2.19.0
- rest-assured version: 5.3.0
- gson version: 2.10

Instruction for running tests:

- copy git-repository
- used your password and username for qase.io
- open terminal and set following commands:
- mvn clean test for running default suite - SmokeTest.xml
- mvn clean test -DsuiteXmlFile = "RegressionTests.xml"
- mvn clean test -DsuiteXmlFile = "ApiTests.xml"