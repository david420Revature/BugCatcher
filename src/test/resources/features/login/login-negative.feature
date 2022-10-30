Feature: Login

    # test fails because g8tor chomp! are actually valid credentials
    Scenario: Login Correct Username Wrong Password
        Given The employee is on the login page
        When The employee types in g8tor into the username input 
        When The employee types in chomp! into the password input 
        When The employee clicks on the login button 
        Then The employee should see an alert saying they have the wrong password

    # test with an actual invalid password
    Scenario: Login Correct Username Wrong Password
        Given The employee is on the login page
        When The employee types in g8tor into the username input
        When The employee types in chomp into the password input
        When The employee clicks on the login button
        Then The employee should see an alert saying they have the wrong password

    Scenario: Login Wrong Username
        Given The employee is on the login page
        When The employee types in sicEmDawgs into the username input
        When The employee types in natchamps into the password input
        When The employee clicks on the login button
        Then The employee should see an alert saying no user with that username found

        