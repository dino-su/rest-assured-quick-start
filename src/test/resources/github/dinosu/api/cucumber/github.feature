Feature: Github

  Scenario: Get a single user info
    Given username is "dino-su"
    When I access end point: /users/:username
    Then I receive JSON object contains the following
	| name      | Dino Su                                           |
	| bio       | Software Engineer, focusing on test engineering.  |

  Scenario: List user repositories
    Given username is "dino-su"
    When I access end point: /users/:username/repo
    Then I receive JSON array contains the following
    | android-e2e-mock-example      | Android E2E mock testing example.                                                                                                 |
    | android-monkey-quick-start    | This repository contains Android Monkey Test Start Kit which aim to help you enable Monkey Test in continuous testing pipeline.   |
    | clean-scalable-xcuitest       | Sample project of iOS UI test automation using XCUITest.                                                                          |
    | webdriver-io-quick-start      | Webdriver.IO Quick Start                                                                                                          |
    | kkbox-labs                    | Android UI Test Automation and Design Patterns.                                                                                   |
