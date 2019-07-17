@exercise1
Feature: Example01

  Scenario: Different Element Page Test
    Given I am on Home Page
    And I login as
      | userName | password |
      | epam     | 1234     |
    And 'Home Page' page is opened
    And User name should be 'PITER CHAILOVSKII'
    # TODO Where these elements should exist? Could you please specify page?
    # fixed
    And '4' pictures are exist on Home Page
    And '4' texts under pictures are exist on Home Page
    And '2' texts above are exist on Home Page
    When I click on 'Service' button in Header
      # TODO Where these elements should exist? Could you please specify page?
    #fixed
    Then Dropdown list should be displayed on Home Page
    And Dropdown list on Home Page should have 'Support, Dates, Search, Complex Table, Simple Table, User Table, Table With Pages, Different Elements, Performance'
    When  I click 'Service' left menu button
        # TODO Where these elements should exist? Could you please specify page?
  //fixed
    Then Dropdown left list should be displayed on Home Page
    And Dropdown left list on Home Page should have 'Support, Dates, Complex Table, Simple Table, Search, User Table, Table with pages, Different elements, Performance'
    When I click on 'Service' button in Header
    And I click 'Different Elements' service menu button
       # TODO Where these elements should exist? Could you please specify page?
  //fixed
    And '4' checkboxes are exist on Different Elements Page
    And '4' radios are exist on Different Elements Page
    And '1' dropdowns are exist on Different Elements Page
    And '2' buttons are exist on Different Elements Page
    # TODO on which page should these section exist?
  //fixed
    And right section should be on Different Elements Page
    And left section should be on Different Elements Page
    When I select checkboxes 'Water, Wind' on Different Elements Page
    Then Individual log row and value corresponded to the status 'Water' with condition 'true' on Different Elements Page
    And Individual log row and value corresponded to the status 'Wind' with condition 'true' on Different Elements Page
    When I select radio 'Selen' on Different Elements Page
    Then Individual log row and value corresponded to the status 'metal' with condition 'Selen' on Different Elements Page
    When I select dropdown 'Yellow' on Different Elements Page
    Then Individual log row and value corresponded to the status 'Colors' with condition 'Yellow' on Different Elements Page
    When I unselect checkboxes 'Water, Wind' on Different Elements Page
    Then Individual log row and value corresponded to the status 'Water' with condition 'false' on Different Elements Page
    And Individual log row and value corresponded to the status 'Wind' with condition 'false' on Different Elements Page


