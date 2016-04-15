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

##Features which can be used in Student library managment system development :
To be added..