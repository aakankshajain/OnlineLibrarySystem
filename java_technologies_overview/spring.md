#Spring 4.0
================
##Why used : 
It is a MVC framework used to develop web application.

##Technologies replaced by Spring : 
J2EE,Struts,EJB

##Why preffered over older technologies : 
Spring does not restrict to jsp as view technolgy.It provides good integration of other technologies as well.<br>
Spring does not have any dependency on any application servers.So we can switch from one server to another easily.<br>
Spring also provide web services like transection, authentication etc. which are provided by web servers if we use EJBs.So dont require to use web-servers explicitly.Spring provides the facility.<br>
Struts is based on one tier architecture it mean interfaces,backend code all are present on one single server but spring is not.<br>
It provides many templates like jdbc Template for JDBC connection, REST template for restful web services which make development efficient.<br> 
The main functionality of spring is depency injection.What it means is if a application code is dependent on some external part it will be configured by framework itself and will be push to application.It works on push configuration rather than pull configuration.For finding out configurations, framework is reponsible not application code.So without changing application code we can change place from where we are fetching configuration.<br>

##New features :
In higher version of spring for injecting depency in a class we dont need to write xml file..Annotations like @Resources and @component can do this.

##How to develop a project using spring framework :
First of all it iis required to create a maven project.All the directories will be created according to maven folder structure.<br>
create a index.jsp file which will be tthe initial (welcome file) for the project to start with.<br>
Make entry of index.jsp file in web.xml file.web.xml file present in WEB-INF folder.<br>
To use spring framework we need to give entry of dispatcher servlet in web.xml file.This servlet id front controller and handle all http requests.Which again forward the request to respective controller.<br>


	<servlet>
    <servlet-name>springapp</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>springapp</servlet-name>
    <url-pattern>*.htm</url-pattern>
  </servlet-mapping>
  
  Above entry of servlet and servlet mapping should be made in web.xml file. any url pattern with .htm will be routed to dispatcherServlet.<br>
  
  create one more file spring-servlet.xml in WEB-INF.This file will contain mapping of bean files to controllers. Like:
  
  <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">


  <bean name="/<url_for_class>.htm" class="<package_name.class_name"/>

</beans>
  
  When in view file a url will be called corresponding class name will be invoked.
  Mapping for all files to url will be present here.
  
  
  Now create A class(controller class) in src folder which will implement controller interface.This class will give definition to "handleRequest" method of controller interface.
This method will return ModelAndView Object having view file name in its argument.
Internally view resolver resolve all these url mappings.

Create view file to which we are redirecting from controller class.

execute mavan command(clean and install) and build a package.
and run it on server.

These are the basic steps for spring application.  


