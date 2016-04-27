#JPA (Java Persistance API)

JPA is a collection of classes nd methods which stores data into database persistantly. JPA is basically used to perform database operations efficienty and provides a connecting chain between java program and database. It is provided by Oracle.

To use JPA we need to use JPA Provider framework. It makes easier to interact with database.
JPA is open source API which is included in many tools like eclipse,redHat etc.

JPA consider POJO as a record of database.

###Classes and interfaces used :

Persistance : It is a class which has a static method to create instance of EntityManagerFactoty.
EntityManagerFactory : It is a factory class for EntityManager interface. Also manages multiple objects of EntityManager.
EntityManager :  It is a interface works like factory of Query instance. It is used to manage the persistance operation on objects.
Query : It is a interface used to fetch data from database.
Entity  : It is a record in form of object which store in database.
EntityTransection : It has one to one relationship with EntityManager. 

###ORM (Object Relational Mapping) : 

Previously what was the scenario we were needed to write code to store object into relational database everytime.We explicitly needed to maintain those records.This was very tedious task.
Now to reduce these overheads we are moving to object relation mappings.in which we only need to provide a .xml file containing all mappings between POJOs and relational database and data insertion maintenance etc operations are automatically handled.
ORM is a technology that converts object type data to relation database records and vice versa.

The benefit for .xml file is it does not require compilation so we can easily make changes anytime.

###How it works :
There are three phases : 
1. In first phase there are POJOs. Classes whose object are being stored in database as records.
2. Second phase is JPA provider (eg : Hibernate), A framework or platform which will persist data to store in database and a xml mapping file.
Third phase is a relational database which will store data.

In first phase data is in transient state what it means is object of classes which we want to store is initially in transient state.
In second phase when data binded with JPA provider comes in peersistant state.
In last phase persistent data stored in database as  record.

#Mapping file

Mapping file is a .xml file. It contains mapping between a java class and its corresponding table in database.
Java class contain variables (a variable corresponding to a column in table to which class pointing to) and getters and setters for that variable.

Eg : Student.java class mapped to StudentInfo table in database. Then mapping file would be : 

DTD
entity-mapping ...
entity class="Student"
	table name="StudentInfo"/
	
	attributes
		
		id name="studentId"
		column name="student_id"
		generated-value=".."
		/id
		
		basic name="name"
		column name="studentName"
		/basic
		
/attributes

/entity
/entity-mapping


As Student.java is like this

class Student {
	String id;
	String name;
	
	public void setId(String id){
		this.id=id;
	}
	public void setName(String Name){
		this.name=name;
	}
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
}


In xml file : 
1. write DTD
2. entity-mapping : allows entity tag in xml file
3. entity : for mapping between java class and database table
4. id : for defining primary key
5. generated-value : for specifying hoe primary key would be generated.
6. basic : for mapping rest variables of class with column of tables.
