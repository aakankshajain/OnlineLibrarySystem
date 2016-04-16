#JAX-RS

JAX-RS is a java based API which makes easier to develop rest web servies by using a lot of annotations.
### What REST  is :

REST is an architecture where some resources(methods) are present at server side.And client has access to use those resources and perform some operations.
Some HTTP methods are used for this purpose. Like GET(provides a read only access to resources),POST(To update existing resources),PUT(To create new resources),DELETE(To delete resources),OPTIONS

###RESTful webservices :
web services are basically collection of open protocol to exchange data between two applications written in two different languages and running on two different platform.web services provides interoperability between two application.This communication can happen in many ways like request and response can be sebt in xml format or JSON object is another way of representation.
For eg : There are is website in ehich we have a functionality user regitration, but we dont have so much budget to buy our own database.
So what we will do is, we will use web services of those who provides databases to store data.We will send data in xml format (request) to server through web service and that will be store in database and database will again send the response if need accoordingly.

Those webservices which uses REST architecture are known as RESTful web services.These webservices make use of HTTP methods like GET,POST,PUT .DELETE.OPTIONS.

###How to develop RESTful webservice:
We can use Jersey framework to develop RESTful webservices.Jersey framework uses JAX-RS APIs for developing the same, which makes the development easier.

1. Create a maven project.(Online library management system)
2. Make following entry in pom.xml for downloading required libraries for Jersey framework.

<dependencies>
	
		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-server</artifactId>
			<version>1.8</version>
		</dependency>

	</dependencies>
	
3.create a rest service(.java file) in /src folder.
4.make entry com.sun.jersey.spi.container.servlet.ServletContainer in web.xml. Also make entry of rest service in web.xml.

	<servlet>
		<servlet-name>jersey-serlvet</servlet-name>
		<servlet-class>com.sun.jersey.spi.container.servlet.ServletContainer</servlet-class>
	
		<init-param>
		     <param-name>com.sun.jersey.config.property.packages</param-name>
		     <param-value>src.main.java.online.library.system.actionClasses</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>jersey-serlvet</servlet-name>
		<url-pattern>/rest/*</url-pattern>
	</servlet-mapping>


	
