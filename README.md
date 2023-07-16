# WebAutomation-TestNG-OrangeHRM
In this repository I have automated the OrangeHRM with different scenario. Create Smoke & Master Suite for easy execution. Also generated the Allure Report for better visibility.

## Technology used:
- Selenium Webdriver
- TestNG Framework
- Java
- Gradle
- Intellij idea
- Allure Report

## How to run this project

- Clone this project
- Hit the following command into the terminal:
 ```gradle clean test```
 
- For generating Allure Report use these commands:
```allure generate allure-results --clean -o allure-report``` and
```allure serve allure-results```

## Assigned Work Scenerio:

1. log in as a admin to https://opensource-demo.orangehrmlive.com/
2. Go to PIM menu and create a new employee. Save the employee firstname, lastname, employeeid, username and password into JSONArray file. Generate random password which meets following criteria:
For a strong password, please use a hard to guess combination of text with upper and lower case characters, symbols and numbers. Assert if employee is created successfully.

3. Now go to the dashboard again and search by the employee id to check if the employee is found _(could not generate because in the dashboard panel, there is no search functionality exist. There i have search the employee username from ADMIN tab)_
4. Now go to the Directory menu and search by employee name and check if the employee is found
5. Logout the session.
6. Now login with the newly created employee creds
7. Assert your full name is showing besides the profile icon.
8. Go to my info
9. Scroll down and select Gender and Blood Type as O+ and save it. Then logout the user.
10. Create a smoke suite configuration which will run only following features (positive cases only):
- Login to admin
- search by the employee id if found
- logout admin and login to the employee id you created last
- Update the blood Group as AB-
- Logout the user

## Test case sheet:
https://docs.google.com/spreadsheets/d/1-RC1HgEJm_2bM41JdL4L5vdZrwB3cjjycT649Tx8DF0/edit?usp=sharing

## Allure Report for Master Suite Execution:
![master suit overview](https://github.com/foysal619/WebAutomation-TestNG-OrangeHRM/assets/61048879/dd516f9f-464d-4bc3-a87c-21fc3e0dce99)

![master suite behaivior](https://github.com/foysal619/WebAutomation-TestNG-OrangeHRM/assets/61048879/a7b544c4-38d4-4531-a187-fd6154d07aeb)

## Allure Report for Smoke Suite Execution:
![smoke suite overview](https://github.com/foysal619/WebAutomation-TestNG-OrangeHRM/assets/61048879/c579cd56-784f-450d-9779-a4bfcda79398)

![smoke suite behaivior](https://github.com/foysal619/WebAutomation-TestNG-OrangeHRM/assets/61048879/8c1855b7-a621-4b6e-899c-c970f61a506f)

## Automation Demonstration Video (Master Suite Execution):
https://github.com/foysal619/WebAutomation-TestNG-OrangeHRM/assets/61048879/e51e2e15-8177-4edc-b202-9301c0f1725f

## Automation Demonstration Video (Smoke Suite Execution):
https://github.com/foysal619/WebAutomation-TestNG-OrangeHRM/assets/61048879/c00c8af4-41b4-4f2c-ae04-09f21ab37f88





