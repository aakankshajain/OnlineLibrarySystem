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
4.make entry com.sun.jersey.spi.container.servlet.ServletContainer in web.xml. Also make entry of package in which rest services exists in web.xml.

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

5.Now create java file in the above mentioned package which provide rest service.
	Class which is exposed to use by client will have a path,and the method of that service will also have the path.For eg :
	If we create serach book functionality for librarian how we have to write the code is:
	
	SearchBookRestService.java
	
	@Path(name="SearchBookLib")
	Class SearchBookRestService{
		
		@Get
		@Path(name="getBookList")
		@Response(application_xml)
		public List<BookList> getBookList(@PathParam("getBookList")String serchValue){
		
			SearchBookDao sbdao=new SearchBookDao();
			retrun searchBook(searchValue);
		}
	
	}
	
	SearchBookDao.java
	
	class SearchBookDao{
		public List<BookList> searchBook(String searchValue){
		
			List<BookList> list=new List<BookList>();
			//Fetch all the records based on search value and add into list.
			
			return list;
		
		
		}
	}
	
	BookList.java
	
	@XmlRootElement(name="Book")
	Class BookList{
	
		private String name;
		private String author;
		private String subject;
		
		public getName(){
			return this.name;
		}
		
		@XmlElement
		public setName(String name){
			this.name=name;
		}
		
		public getAuthor(){
			return this.author;
		}
		
		@XmlElement
		public setAuthor(String author){
			this.author=author;
		}
		
		public getSubject(){
			return this.subject;
		}
		
		@XmlElement
		public setSubject(String subject){
			this.subject=subject;
		}
	}

To test services after deploying the war file on server.We need to hit the url : http://localhost:8080/<project_name>/<classPath>/<functionPath>/<path_params>
http://localhost:8080/olms/SearchBookLib/getBookList/java+herbert

We will get the response in xml format.
<p>
<Book>
	<name>...</name>
	<author>...</author>
	<subject>...</subject>
</Book>
</p>
