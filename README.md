Quote Generator Backend
Overview
The Quote Generator Backend is a simple Scala application using the http4s library for HTTP server functionality and circe for JSON handling. The application provides a REST API endpoint that serves a list of predefined quotes in JSON format.

Features
REST API: Provides an endpoint to fetch a list of quotes.
JSON Serialization: Utilizes circe for converting Scala case classes to JSON.
HTTP Server: Runs a server using http4s and BlazeServerBuilder.
Getting Started
Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
Java: Ensure you have Java 11 or later installed.
sbt: Scala Build Tool (sbt) is required to build and run the project.
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/Gracepinkie/quote-generator-backend.git
Navigate into the project directory:

bash
Copy code
cd quote-generator-backend
Build the project:

bash
Copy code
sbt clean compile
Running the Application
To run the application, use the following sbt command:

bash
Copy code
sbt run
By default, the server will start on http://localhost:8080.


SLF4J Warning
If you encounter SLF4J warnings about a missing logger implementation, you can resolve this by adding Logback to the project dependencies. Add the following line to your build.sbt file:

scala
Copy code
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.7"
Then, run sbt clean compile to recompile the project.

Dependencies
http4s: 0.23.12
circe: 0.14.6
cats-effect: 3.5.1
License
This project is licensed under the MIT License - see the LICENSE file for details.

Contributing
If you want to contribute to this project, please fork the repository and submit a pull request with your changes. Ensure that your changes include appropriate tests and documentation.

Contact
For any questions or issues, please contact Sinethemba!!.
