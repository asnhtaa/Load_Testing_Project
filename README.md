
# TVmaze API Load Testing Project
## Overview
The TVmaze API Load Testing Project is designed to assess the performance and reliability of the TVmaze REST API, which provides TV show information through a free, fast, and clean interface. The project utilizes Gatling, an open-source load testing tool, to simulate various user scenarios and interactions with the API endpoints. By executing these tests, the project aims to identify potential bottlenecks, measure response times under load, and ensure the API can handle concurrent user requests effectively.

## In this project, three different load testing profiles are implemented:

* Volume Testing for show scenarios:
This profile aims to simulate heavy loads on the system to assess its performance under high traffic conditions. The scenario gradually increases the number of concurrent users over a specific period, starting from a low value and ramping up to a maximum number of users. This allows evaluating the system's scalability and identifying its capacity limits.
* Step Load Testing for people scenarios:
This profile represents a stepped load pattern, commonly known as the "sawtooth" pattern. It starts with a low number of users and gradually increases the load to a peak level, then decreases it back to a minimum level. By following this pattern, it helps identify how the system behaves under varying loads and assess its stability and resilience over time.
* Stress Testing for episode scenarios:
This profile is designed to determine the upper limit of system capacity by incrementally increasing the load in steps. It executes scenarios with increasing numbers of users at each step, with each level lasting for a specified duration and separated by ramp-up periods. This approach allows stress testing the system to identify its breaking point or performance degradation under extreme loads.

## Tools and Technologies
* Gatling for load testing scenarios.
* Java 17 for development and test execution.
* Maven for project management and dependency handling.
* Logback for logging and result analysis.

## Setup Instructions

1) Install Java Development Kit (JDK) on your system. You can download the JDK from the [official Oracle website](https://www.oracle.com/). Verify your Java installation by running the following command in the terminal or command prompt:

```
java -version
```

2) Install Apache Maven on your system. You can download it from the [Apache Maven website](https://maven.apache.org/) and follow the installation instructions for your operating system.

3) Clone this repository to your local machine

```
git clone https://github.com/asnhtaa/Luma_UI_Project.git
```

4) Open a terminal or command prompt, navigate to the project directory, and run the following command to build the project and execute the tests:

```
mvn clean test
```

5) The tests will start running on the Chrome browser.
