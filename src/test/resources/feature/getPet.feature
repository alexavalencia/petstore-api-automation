Feature:  Retrieve pet information


  Scenario: Successfully retrieved pet by ID.
    Given user has access to the endpoint "GET_PET_BY_ID"
    When user makes a request to get the pet with id 2
    Then user should get the response code 200
    And user validates the response with JSON schema "getPetByIdSchema.json"

  Scenario: Invalid Id
    Given user has access to the endpoint "GET_PET_BY_ID"
    When user makes a request to get the pet with id 27895
    Then user should get the response code 404
    And Error message should be "Pet not found"


  Scenario: Successfully retrieved pet by tags.
    When user perform a request to the endpoint "GET_PET_BY_TAGS" with the params
        |tags |
        |tag3 |
    Then user should get the response code 200
    And user validates the response with JSON schema "getPetByTagsSchema.json"

  Scenario: Invalid tag value.
    When user perform a request to the endpoint "GET_PET_BY_TAGS" with the params
      |tags |
      |t125 |
    Then user should get the response code 400
    And Error message should be "Invalid tag value"


  Scenario: Successfully retrieved pet by Status.
    When user perform a request to the endpoint "GET_PET_BY_STATUS" with the params
      |status |
      |available |
    Then user should get the response code 200
    And user validates the response with JSON schema "getPetByTagsSchema.json"


  Scenario: Invalid status.
    When user perform a request to the endpoint "GET_PET_BY_TAGS" with the params
      |status |
      |new    |
    Then user should get the response code 400
    And Error message should be "Invalid status value"