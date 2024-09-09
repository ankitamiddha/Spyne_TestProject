# Spyne_TestProject
Spyne.ai Image Upscaler - Automated Testing with Selenium WebDriver
This project automates the testing of the core functionalities of the Spyne.ai Image Upscaler using Selenium WebDriver.

Objective

The goal is to achieve comprehensive testing of the image upscaling process, ensuring its functionality and user experience across various browsers and scenarios.

Link

Spyne.ai Image Upscaler: https://www.spyne.ai/image-upscaler

**Tools & Technologies**

**Programming Language:** Java
**Automation Framework:** Selenium WebDriver
**Test Runner:** TestNG
**Reporting:** Allure Reports
**Browsers Supported:** Chrome, Firefox, Edge (including headless mode)

**Prerequisites**
Java 1.8
IDE (e.g., IntelliJ IDEA)
Maven and Allure installed on the system

**Project Structure**
The project follows a standard Maven project structure:

**src/main/java:** Contains base classes, listeners, page objects, and utility classes related to the tests.

**src/main/resources:** Stores configuration files (allure.properties, config.properties), sample image and text files.

**src/test/java:** Holds the com.qa.testcases package containing test case classes.

**pom.xml:** Defines project dependencies and build configuration.

**testing.xml:** The TestNG runner file.

**README.md:** This file (you're reading it!).

**target:** Stores Allure report artifacts after test execution.


**Command to Run Tests:**

Go to the directory - Spyne_TestProject\Spyne_TestProj and run-
mvn test

**Command to Generate Reports:**

Go to the directory - Spyne_TestProj/target and run - 
allure generate

**Open Allure Reports:**
allure open

**Design Pattern -** Page Object Model (POM) Implemented

The project employs the Page Object Model design pattern for better code organization and maintainability.

**Assumptions**

Captcha functionality requires manual intervention. Test scripts include wait times to allow for manual captcha handling before proceeding to download.
Email verification is bypassed by using a temporary email address (abc@mailinator.com). Disabling captcha verification is required for scaling tests (provided by the development team).

**Test Cases Automated - **

Navigation (com.qa.testcases.TestCasesDashboard)
Verifies successful navigation to the Spyne.ai Image Upscaler page.
Checks for correct URL and presence of key page elements. 

File Upload (com.qa.testcases.TestCasesDashboard)
Uploads a valid image file and confirms successful upload.

Invalid File Upload (com.qa.testcases.TestCasesDashboard)
Attempts to upload an invalid file type and validates appropriate error handling.

Image Upscaling (com.qa.testcases.TestCasesScaling)
Verifies that image upscaling starts and completes successfully after uploading an image.

UI Validation (com.qa.testcases.TestCasesScaling)
Confirms the presence and functionality of essential UI elements like upload button, image preview, and download button.

Download Functionality (com.qa.testcases.TestCasesScaling)
Ensures that the upscaled image can be downloaded after processing.

Multi-Browser Execution(Testng.xml)
Tests can be run across Chrome, Firefox, and Edge (including headless mode) by parameterizing the browser type in the testing.xml file and accessing it from the Base Class.

This README provides a comprehensive overview of the project's functionalities and setup instructions. For further details, refer to the code within the project directory.
