# zs-appium-generic-automation
## Introduction
This repository contains the automation scripts for testing Android application under the Zopping project. The tests are automated using Appium, TestNG, and other relevant tools. The goal of this project is to ensure the stability and functionality of various Android applications.
## Applications Automated
- Tamimi
- Vijetha
- Brimbary
- Ekam
## Technologies Used
- Appium
- TestNG
- Maven
- Java
- ExtentReports
## Project Structure
```plaintext
zs-appium-generic-automation/
├── .github/
│   └── workflows/
│       └── ci.yml
├── .idea/
│   ├── inspectionProfiles/
│   │   └── Project_Default.xml
│   ├── .gitignore
│   ├── encodings.xml
│   ├── misc.xml
│   ├── uiDesigner.xml
│   └── vcs.xml
├── docs/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── zs/
│                   ├── constants/
│                   │   └── Constants.java
│                   ├── locators/
│                   │   ├── BrimbaryLocators.java
│                   │   ├── EkamLocators.java
│                   │   ├── TamimiLocators.java
│                   │   └── VijethaLocators.java
│                   ├── pages/
│                   │   ├── common/
│                   │   │   ├── CartPage.java
│                   │   │   ├── CheckoutPage.java
│                   │   │   ├── Flows.java
│                   │   │   ├── HomePage.java
│                   │   │   ├── LoginPage.java
│                   │   │   ├── ProductsPage.java
│                   │   │   └── ProfilePage.java
│                   │   ├── tamimi/
│                   │   │   ├── CartPageTamimi.java
│                   │   │   └── ProfilePageTamimi.java
│                   │   └── vijetha/
│                   │       └── LoginPageVijetha.java
│                   ├── utils/
│                   │   ├── CommonUtils.java
│                   │   ├── ConfigReader.java
│                   │   ├── ExcelUtils.java
│                   │   ├── ExtentReport.java
│                   │   ├── LoggerUtil.java
│                   │   └── OrderManager.java
│                   └── resources/
│                       ├── apps/
│                       │   ├── app-brimbary-debug.apk
│                       │   ├── app-ekam-debug.apk
│                       │   ├── app-vijethasupermarkets-debug_latest.apk
│                       │   └── app-visionstg-debug.apk
│                       ├── config.properties
│                       ├── log4j2.xml
│                       └── login_details.xlsx
├── test/
│   └── java/
│       ├── base/
│       │   └── BaseTest.java
│       └── test/
│           ├── AddProductToCartTest.java
│           ├── CancelOrderTest.java
│           ├── CheckoutTest.java
│           ├── EditProfileTest.java
│           ├── FilterTest.java
│           ├── LoginNegativeTest.java
│           ├── LoginTest.java
│           ├── LogoutTest.java
│           ├── SearchTest.java
│           └── ValidateMaxProductQuantityTest.java
├── .gitignore
├── README.md
├── pom.xml
├── testngBrimbary.xml
├── testngEkam.xml
├── testngTamimi.xml
└── testngVijetha.xml
```
## Setting up the Project
### Prerequisites
- Java
- Maven
- Appium
- Android Studio
- ExtentReports
### Installation and Setup
- Clone the Repository:
  ```
  git clone <repo-url>
  cd <project-directory>
  ```
- Install Dependencies: ``` mvn install ```
- Set up Appium and Android Emulator using Android Studio.
- Run Tests: Run the tests using the respective ```testng.xml``` file of the application.
## Execution Result
The reports are generated and can be viewed in the ```/reports``` folder.
  



