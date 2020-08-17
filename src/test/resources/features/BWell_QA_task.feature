@desktop @web
#As a <type of user> I want <some goal> so that <some reason>
Feature: BWell Automation QA Task
  As a QA who is interested in BWell
  I want to solve interview task
  So that I can be confident if get invited on a meeting

  Scenario: User can Sign in with valid credentials
    Given I am on "http://login.myappcms.com/" home page
    When I type "CMS Demo Account" as App Name
    And I type "demo@diyappdesigner.com" as Email address
    And I type "demo123" as Password
    And I click on Sign in button
    Then I should see my Dashboard

  Scenario: User can sort in ascending order all Appointments services by name
    Given I am on "http://login.myappcms.com/build" page
    When I click "Sort Ascending" on "Service Name" column
    Then I should see correct results list


  Scenario: User can search all Appointments services by name
    Given I am on "http://login.myappcms.com/build" page
    When I type "colour" in the Search box
    Then I should see correct results list that elements start with "colour"
# personal test cases below
  Scenario:  Users can navigate to Analytic page from build page
    Given I am on "http://login.myappcms.com/build" page
    When I click Analytics tab
    Then  I should be on "http://login.myappcms.com/analyze"

  Scenario:  User can click social media tag on Analytic Page
    Given I am on "http://login.myappcms.com/analyze" page
    When  I click Social Media tab
    Then social media statistic board should display

  Scenario: User should make Appointments services full screen
    Given I am on "http://login.myappcms.com/build" page
    When I click on full screen button
    Then  I should see  page display in full screen mode
