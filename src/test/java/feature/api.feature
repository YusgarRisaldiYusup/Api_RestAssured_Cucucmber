Feature: Api Automation

  @CaseID=2
  @api
  Scenario: Get All User
    Given Prepare Url for "GET_ALL_USERS"
    And hit api get list users
    And verify status code is 200
    Then verify response body get list users
    And verify using json schema "GET_USER_BY_ID.json"

  @CaseID=3
  @api
  Scenario: Get User By Id
    Given Prepare Url for "CREATE_NEW_USER"
    Then Hit api for Create new user
    And verify status code is 201
    And verify body response for create new user
    Then Hit api for get user by id
    And verify status code is 200
    And verify body response for get user by id
    And verify using json schema "GET_ALL_USER_BY_ID.json"

  @CaseID=4
  @api
  Scenario: Create New User
    Given Prepare Url for "CREATE_NEW_USER"
    Then Hit api for Create new user
    And verify status code is 201
    And verify body response for create new user

  @CaseID=5
  @api
  Scenario: Update Data Active User
    Given Prepare Url for "CREATE_NEW_USER"
    When Hit api for Create new user
    And verify status code is 201
    And verify body response for create new user
    Then Hit api for update data active user
    And verify status code is 200
    And verify body response for update data active user

  @CaseID=6
  @api
  Scenario: Delete Active User
    Given Prepare Url for "CREATE_NEW_USER"
    When Hit api for Create new user
    And verify status code is 201
    And verify body response for create new user
    Then Hit api for Delete Active User
    And verify status code is 204


