$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Org Admin Login feature",
  "description": "",
  "id": "org-admin-login-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Org admin login Scenario",
  "description": "\r\n//Prequisities",
  "id": "org-admin-login-feature;org-admin-login-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "User should be available on the Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Title of login page matches",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User Enters the Email and Password",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User clicks on login button",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginstepDefinition.Login_Button()"
});
formatter.result({
  "duration": 27156729000,
  "status": "passed"
});
formatter.match({
  "location": "LoginstepDefinition.Login_Page_Title()"
});
formatter.result({
  "duration": 11384700,
  "status": "passed"
});
formatter.match({
  "location": "LoginstepDefinition.Enter_Credentials()"
});
formatter.result({
  "duration": 9345229600,
  "status": "passed"
});
formatter.match({
  "location": "LoginstepDefinition.click_LoginButton()"
});
formatter.result({
  "duration": 2030978100,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});