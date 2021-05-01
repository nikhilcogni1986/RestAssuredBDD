Feature: Validating Place API's

  Scenario Outline: To validate whether place is added using Add Place API
    Given Add Place Payload with "<Name>" "<Address>" "<Language>"
    When User calls "AddPlaceAPI" with Post http request
    Then API returns a success with the status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | Name    | Address            | Language   |
      | Charles | World Trade Center | English UK |