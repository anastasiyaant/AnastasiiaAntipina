@exercise1
Feature: Example01
  Scenario: Different Element Page Test
    Given I am on Home Page
    And I login as
      | userName | password|
      | epam | 1234|
    And 'Home Page' page is opened
    And User name should be 'PITER CHAILOVSKII'
    And '4' pictures are exist
    And '4' texts under pictures are exist
    And '2' texts above are exist
    When I click on 'Service' button in Header
    Then Dropdown list should be displayed
    And Dropdown list should have 'Support, Dates, Search, Complex Table, Simple Table, User Table, Table With Pages, Different Elements, Performance'
    When  I click 'Service' left menu button
    Then Dropdown left list should be displayed
    And Dropdown left list should have 'Support, Dates, Complex Table, Simple Table, Search, User Table, Table with pages, Different elements, Performance'
    When I click on 'Service' button in Header
    And I click 'Different Elements' service menu button
    And '4' checkboxes are exist
    And '4' radios are exist
    And '1' dropdowns are exist
    And '2' buttons are exist
    And right section should be
    And left section should be
    When I select checkboxes 'Water, Wind'
    Then Individual log row and value corresponded to the status 'Water' with condition 'true'
    And Individual log row and value corresponded to the status 'Wind' with condition 'true'
    When I select radio 'Selen'
    Then Individual log row and value corresponded to the status 'metal' with condition 'Selen'
    When I select dropdown 'Yellow'
    Then Individual log row and value corresponded to the status 'Colors' with condition 'Yellow'
    When I unselect checkboxes 'Water, Wind'
    Then Individual log row and value corresponded to the status 'Water' with condition 'false'
    And Individual log row and value corresponded to the status 'Wind' with condition 'false'


