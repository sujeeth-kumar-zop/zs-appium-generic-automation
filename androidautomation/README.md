# android automation
## Introduction
This repository contains the automation scripts for testing Android application for the Eazyupdates project. The tests are automated using Appium, TestNG, and other relevant tools. The goal of this project is to ensure the stability and functionality of various Android applications.
## Applications Automated
- Eazyupdates

## Technologies Used
- Appium
- TestNG
- Maven
- Java
- Appium Inspector
## Setting up the Project
### Prerequisites
- Java JDK (8 or 11+)
- Maven
- Node.js
- Appium CLI (`npm install -g appium`)
- Android Studio (with emulator or physical device support)
- Appium Inspector
- ExtentReports for HTML reporting

### Installation and Setup
* Clone the Repository:
  ```
  git clone <repo-url>
  cd <project-directory>
  ```
* Install the following tools
    - Brew
    - Node
    - Appium
    - Android Studio with Emulator
* Set PATHs for all tools into your system
    - Android Studio
    - Java
    - Maven
    - (might be: appium, node)
* Install - Device Specific Appium Driver
    - android
    - ios
    - etc
* Install Dependencies: ``` mvn install ```
* Set up Appium and Android Emulator using Android Studio.
* Run Tests: Run the tests using the respective ```testng.xml``` file of the application.
* Install Appium globally with npm, then add the uiautomator2 driver using: appium driver install uiautomator2
* Start Appium Server
    - Run appium in your terminal to launch the server.
* Connect Inspector & Begin Session
    - Launch the Inspector Configure the host (127.0.0.1), port (4723), and desired capabilities (e.g. platformName, deviceName, automationName, app path). Click Start Session to load and inspect your app visually
* Stop Appium Server
    - In the terminal running Appium, press Ctrl + Z to gracefully shut down the server.
* Force Kill if Needed
    - If Appium hangs or doesn’t stop with Ctrl +C, use these commands:
    - On macOS/Linux: pkill -9 -f appium
    - On Windows: taskkill /F /IM node.exe.


## Execution Result
The reports are generated and can be viewed in the ```/reports``` folder.


  



