Feature: Validating Place API's

  Scenario: To validate whether place is added using Add Place API
  Given Add Place Payload
  When User calls "AddPlaceAPI" with Post http request
  Then API returns a success with the status code 200
  And "status" in response body is "OK"
  And "scope" in response body is "APP"