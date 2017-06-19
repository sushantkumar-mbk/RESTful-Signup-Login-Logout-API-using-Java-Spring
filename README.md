# hello-world

A simpile Spring JAVA project example for creating RESTful APIs for signup, login, logout and check balance of user iff user is logged in otherwise prompt appropriate errors.
Database used is MongoDB and in order to run the project, mongo-server must be running in background.

Spring-boot is used for easy configuration of the project while concept of Interceptor is used to handle requests on login/logout/checkbalance uri's.

Some error messages are shown in the logcat while some are returned as the response.

Developed on IntelliJ using maven.

Installation Notes:

1. Install MonogDB
2. (Optional) Install Robomongo for gui view of MongoDB database
3. Install POSTMAN chrome extension for making HttpRequests
4. Open project in IntelliJ.
5. Open Pom.xml and install missing dependencies
6. Run application.java. By default the configuration runs the tomcat server on port 8080 which may be used by another service. In order to remove this error, use "-Dserver.port=8000" in the VM Options in your edit configuration file.
7. Use postman or any other application to make Http POST Requests on the urls like: localhost:8000/signup?username=vishal
8. The password is sent via Request Header along with the confirm password for signup url. On successful signup, the server will respond with appropriate message.
