Feature:  Retrieve pet information


  Scenario: Successfully retrieved pet by ID.
    Given user has access to the endpoint "GET_PET_BY_ID"
    When user makes a request to get the pet with id 2
    Then user should get the response code 200
    And user validates the response with JSON schema "getPetSchema.json"

  Scenario: Invalid Id
    Given user has access to the endpoint "GET_PET_BY_ID"
    When user makes a request to get the pet with id 27895
    Then user should get the response code 404
    And Error message should be "Pet not found"


