Scenario: Logging in to user yandex email account
Given the user is on http://mail.yandex.kz page
When user enters login, password and clicks login button
Then user should get to yandex email inbox page

Scenario: Composing a new message and saving it to drafts list
Given user starts composing a message
When user clicks cancel button
Then he should be able to find his message in drafts list

Scenario: Opening a draft and sending it
Given that a user opens a saved draft
When he checks it for integrity and sends it
Then he should be able to find his message in sent messages list