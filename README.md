Data Integration Platform README
1. Adapter Service
Purpose: Accepts JSON data and persists it for further processing.

Prerequisites:
Java 8 or higher
Maven
PostgreSQL
Setup:
Database Configuration:

Make sure PostgreSQL is up and running.
Set up the necessary tables as defined by JsonRecord entity.
Update the application.properties with your database connection details.
Build & Run:

bash
Copy code
cd AdapterService
mvn clean install
java -jar target/AdapterService-0.0.1-SNAPSHOT.jar
2. Routing Service
Purpose: Checks unprocessed JSON records from the Adapter Service and forwards them to the Transformation Service.

Prerequisites:
Java 8 or higher
Maven
PostgreSQL
Setup:
Database Configuration:

Ensure the JsonRecord table is available, as set up from the Adapter Service.
Update application.properties with your database connection details.
Build & Run:

bash
Copy code
cd RouterService
mvn clean install
java -jar target/RouterService-0.0.1-SNAPSHOT.jar
3. Transformation Service
Purpose: Receives JSON data, converts it into XML, and pushes it to an ActiveMQ queue.

Prerequisites:
Java 8 or higher
Maven
ActiveMQ
Setup:
ActiveMQ Configuration:

Download and install ActiveMQ.
Start the ActiveMQ server.
Ensure the ActiveMQ web console is accessible at http://localhost:8161/ (default credentials are admin/admin).
Service Configuration:
Update the application.properties or any configuration file with the correct ActiveMQ connection details.

Build & Run:

bash
Copy code
cd TransformationService
mvn clean install
java -jar target/TransformationService-0.0.1-SNAPSHOT.jar
General Usage:
Push JSON Data:
Send a POST request with JSON data to the Adapter Service at http://localhost:8080/ingest.

Automatic Routing:
The Routing Service will automatically pick up unprocessed records every 5 minutes and send them to the Transformation Service.

Transformation and Queue:
The Transformation Service converts the JSON data into XML format and pushes it to the ActiveMQ queue.

Troubleshooting:
If services are not starting, check the database and ActiveMQ connections.
Ensure that the required tables and queues exist in PostgreSQL and ActiveMQ respectively.
Monitor the ActiveMQ web console for any issues with the queue.
